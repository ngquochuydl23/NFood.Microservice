const { BaseRatingSchema } = require('../baseRatingSchema');
const mongoose = require('mongoose');
const schemeConstants = require('./schemeConstant');

module.exports = mongoose.model(schemeConstants.Model, BaseRatingSchema(schemeConstants.Collection, {
    driverId: {
        type: Number,
        required: [true, 'itemId must not be null']
    }
})); 