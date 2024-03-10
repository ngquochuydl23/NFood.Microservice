const mongoose = require('mongoose');
const schemeConstants = require('./schemeConstant');
const { BaseRatingSchema } = require('../baseRatingSchema');

module.exports = mongoose.model(schemeConstants.Model, BaseRatingSchema(schemeConstants.Collection, {
    restaurantId: {
        type: String,
        required: [true, 'restaurantId must not be null']
    }
})); 