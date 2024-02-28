const express = require('express');
const router = express.Router();
const RestaurantModel = require('../models/restaurant');
//const auth = require('../config/oauth2');

// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })

router.get('/', async (req, res) => {
    try {
        const restaurant = await RestaurantModel.findById(req.params.id)
        if (!restaurant) {
            return res
                .status(400)
                .send({
                    statusCode: 400,
                    error: 'Restaurant does not exist'
                });
        }

        return res
            .status(200)
            .send({
                statusCode: 200,
                result: restaurant
            });

    } catch (error) {
        return res
            .status(500)
            .send({
                error: error.message,
                statusCode: 500
            });
    }
})

router.put('/', async (req, res) => {
    try {
        const restaurant = await RestaurantModel.findById(req.params.id, '-contact');
        if (!restaurant) {
            return res
                .status(400)
                .send({
                    statusCode: 400,
                    error: 'Restaurant does not exist'
                });
        }

        restaurant = {
            ...restaurant,
            ...req.body
        }
        await restaurant.save();
    } catch (error) {
        return res
            .status(500)
            .send({
                error: error.message,
                statusCode: 500
            });
    }
})

router.delete('/', async (req, res) => {

});


module.exports = router;