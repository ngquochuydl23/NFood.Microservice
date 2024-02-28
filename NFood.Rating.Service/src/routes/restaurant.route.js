const express = require('express');
const router = express.Router();
const RestaurantRating = require('../models/restaurantRating');
const { findRestaurantById } = require('../external-api/restaurant.external.api');
//const auth = require('../config/oauth2');

// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })


// define the home page route
router.get('/:restaurantId/', (req, res) => {
    try {
        res.send(req.params.restaurantId)
    } catch (error) {
        console.log(err)
    }
});


router.post('/:restaurantId/', async (req, res) => {
    try {
        const restaurantId = req.params.restaurantId;
        const { content, rating, reviewerId } = req.body;

        const [restaurant, reviewer] = await Promise
            .all([
                findRestaurantById(req, restaurantId),
                (async) => ({
                    id: 1,
                    fullName: 'Nguyễn Quốc Huy',
                    avatar: '/storage/image/'
                })])
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
            reviewer: {
                id: 1,
                avatar: '/storage/',
                fullName: 'Nguyễn Quốc Huy',
            }
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