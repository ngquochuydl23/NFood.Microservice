const express = require('express');
const router = express.Router();
const DriverRating = require('../models/driverRating');
//const auth = require('../config/oauth2');

// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })

router.get('/:driverId/', async (req, res) => {
    try {
        const ratings = await DriverRating
            .find({ driverId: req.params.driverId })
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

module.exports = router;