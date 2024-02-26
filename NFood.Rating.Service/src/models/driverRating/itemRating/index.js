const { BaseRatingSchema } = require('../driverRating/baseRatingSchema');
const mongoose = require('mongoose');
const schemeConstants = require('./schemeConstant');

module.exports = mongoose.model(schemeConstants.Model, BaseRatingSchema(schemeConstants.Collection, {
    itemId: {
        type: Number,
        required: [true, 'itemId must not be null']
    },
    restaurantId: {
        type: String,
        required: [true, 'restaurantId must not be null']
    }
})); 