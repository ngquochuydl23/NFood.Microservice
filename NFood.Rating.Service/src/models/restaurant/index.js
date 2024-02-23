const mongoose = require('mongoose');
const schemeConstants = require('./schemeConstant');
const { BaseSchema } = require('../share.model');

module.exports = mongoose.model(schemeConstants.Model, BaseSchema(schemeConstants.Collection, {
    title: { type: String },
    avatar: { type: String },
    cuisine: [],
    ratingAndReviews: { type: Number },
    minimum: { type: Number },
    contact: {},
})); 