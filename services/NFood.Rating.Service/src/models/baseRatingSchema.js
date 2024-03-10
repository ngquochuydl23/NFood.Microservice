const { BaseSchema } = require('./share.model');


function BaseRatingSchema(collection, schema) {
    return BaseSchema(collection, {
        content: {
            type: String,
            required: [false]
        },
        rating: {
            type: Number,
            required: [true, 'Rating must not be null'],
            min: [0, 'Rating must be positive'],
            max: [5, 'Rating must litle than 5'],
        },
        reviewer: {
            id: {
                type: Number,
                required: [true, 'reviewer.id must not be null']
            },
            avatar: {
                type: String,
                required: [false]
            },
            fullName: {
                type: String,
                required: [true, 'reviewer.fullName must not be null']
            }
        },
        ...schema
    })
}

module.exports = { BaseRatingSchema }