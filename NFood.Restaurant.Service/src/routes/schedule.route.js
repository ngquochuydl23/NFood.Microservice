const express = require('express');
const router = express.Router();
const RestaurantSchema = require('../models/restaurant');
const ScheduleSchema = require('../models/schedule');

// const auth = require('../config/oauth2');
// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })

router.post('/', async (req, res) => {
    const restaurantId = '65d60aefec74a44f273aec4a';

    try {
        const schedule = new ScheduleSchema({
            periods: req.body.periods,
            restaurantId: restaurantId
        });

        await schedule.save();

        return res
            .status(201)
            .send({
                statusCode: 201,
                result: schedule
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
});

router.put('/', async (req, res) => {

});

module.exports = router;    