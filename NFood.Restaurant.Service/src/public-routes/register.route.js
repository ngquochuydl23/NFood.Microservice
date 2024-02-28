const express = require('express');
const router = express.Router();
const RestaurantModel = require('../models/restaurant');
const bcrypt = require('bcrypt');

router.post('/', async (req, res) => {
    try {
        if (!(req.body.password)) {
            return res
                .status(400)
                .send({
                    statusCode: 400,
                    error: 'body.password is null or empty'
                });
        }

        const saltRounds = 10;
        const hashPassword = await bcrypt.hashSync(req.body.password, saltRounds);

        const restaurant = new RestaurantModel({
            ...req.body,
            hashPassword: hashPassword,
            active: false,
            isDeleted: false
        });

        await restaurant.save();
        return res
            .status(201)
            .send({
                statusCode: 201,
                result: restaurant
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
