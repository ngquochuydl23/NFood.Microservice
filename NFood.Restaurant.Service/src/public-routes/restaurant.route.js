const express = require('express');
const router = express.Router();
const RestaurantSchema = require('../models/restaurant');
const ScheduleSchema = require('../models/schedule')
const geolib = require('geolib');

// const auth = require('../config/oauth2');
// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })

router.get('/', async (req, res) => {
    try {
        const restaurants = await RestaurantSchema
            .find({})
            .exec();

        return res
            .status(200)
            .send({
                statusCode: 200,
                result: restaurants
            });

    } catch (error) {
        return res
            .status(500)
            .send({
                error: error.message,
                statusCode: 500
            });
    }
});

router.get('/:id', async (req, res) => {
    try {
        console.log(req.params.id);
        const restaurant = await RestaurantSchema.findById(req.params.id, '-contact -hashPassword')
        if (!restaurant) {
            return res
                .status(400)
                .send({
                    statusCode: 400,
                    error: 'Restaurant does not exist'
                });
        }

        const { latitude, longitude } = req.query;
        if (latitude && longitude) {
            const { lat, long } = restaurant.location;

            var distance = geolib.getDistance(
                { latitude, longitude },
                { latitude: lat, longitude: long }
            ) / 1000;
        }

        return res
            .status(200)
            .send({
                statusCode: 200,
                result: {
                    closed: false,
                    distance,
                    restaurant
                }
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


module.exports = router;