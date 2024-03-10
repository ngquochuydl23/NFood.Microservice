const express = require('express');
const router = express.Router();
const RestaurantRating = require('../models/restaurantRating');
//const auth = require('../config/oauth2');

// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })

router.get('/:itemId/', async (req, res) => {
    try {


        return res
            .status(200)
            .send({
                statusCode: 200,
                result: null
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
