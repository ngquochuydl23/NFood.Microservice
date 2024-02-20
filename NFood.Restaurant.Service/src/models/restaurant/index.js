const mongoose = require('mongoose');
const schemeConstants = require('./schemeConstant');
const { BaseSchema } = require('../share.model');

module.exports = mongoose.model(schemeConstants.Model, BaseSchema(schemeConstants.Collection, {
    title: {
        type: String,
        required: [true, 'Title must not be null']
    },
    thumbnail: {
        type: String,
        required: [true, 'Thumbnail must be not null'],
    },
    cover: {
        type: String,
        required: [true, 'Cover must be not null'],
    },
    cuisine: [[String]],
    ratingAndReviews: {
        type: Number,
        required: [false],
        min: [0, 'Rating must be positive'],
        max: [5, 'Rating must litle than 5'],
    },
    minimum: {
        type: Number,
        required: [false],
        min: [0, 'Minimum must be positive'],
    },
    contact: {
        phoneNumber: {
            type: String,
            validate: {
                validator: function (v) {
                    return /^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$/.test(v);
                },
                message: props => `${props.value} is not a valid phone number!`
            },
            required: [true, 'Phone number must be not null'],
        },
        email: {
            type: String,
            required: [true, 'Email must be not null'],
            validate: {
                validator: function (v) {
                    return /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(v);
                },
                message: props => `${props.value} is not a valid email!`
            },
        }
    },
    location: {
        lat: {
            type: Number,
            required: [true, 'Latitude must be not null'],
        },
        long: {
            type: Number,
            required: [true, 'Longitude must be not null'],
        },
        address: {
            type: String,
            required: [true, 'Address must be not null'],
        }
    }
})); 