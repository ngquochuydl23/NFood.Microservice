const express = require('express');
const router = express.Router();
const RestaurantRating = require('../models/restaurantRating');
const { findRestaurantById } = require('../external-services/restaurant.external.api');
const { findUserById } = require('../external-services/user.external.api');
//const auth = require('../config/oauth2');

// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })

router.get('/:restaurantId/', async (req, res) => {
    try {
        const ratings = await RestaurantRating
            .find({ restaurantId: req.params.restaurantId })
            .exec();

        return res
            .status(200)
            .send({
                statusCode: 200,
                result: ratings
            });
    } catch (error) {
        return res
            .status(400)
            .send({
                error: error,
                statusCode: 400
            });
    }
});


router.post('/:restaurantId/', async (req, res) => {
    try {
        const restaurantId = req.params.restaurantId;
        const { content, rating, reviewerId } = req.body;

        const [restaurant, reviewer] = await Promise
            .all([
                findRestaurantById(req.headers('Authorization'), restaurantId),
                findUserById(req.headers('Authorization'), reviewerId)
            ])
        findUser(req,)
            .catch((error) => {
                return res
                    .status(400)
                    .send({
                        error: error,
                        statusCode: 400
                    });
            });

        const restaurantRating = new RestaurantRating({
            content,
            rating,
            restaurantId,
            reviewer: reviewer
        });

        await restaurantRating.save();
        return res
            .status(201)
            .send({
                statusCode: 201,
                result: restaurantRating
            });

    } catch (error) {
        if (error.name === "ValidationError") {
            let errors = {};

            Object.keys(error.errors).forEach((key) => {
                errors[key] = error.errors[key].message;
            });

            return res
                .status(400)
                .send({
                    error: errors,
                    statusCode: 400
                });
        }
        return res
            .status(500)
            .send({
                error: error.message,
                statusCode: 500
            });
    }
})


module.exports = router;