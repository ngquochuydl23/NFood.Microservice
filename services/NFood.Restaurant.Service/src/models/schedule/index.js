const mongoose = require('mongoose');
const schemeConstants = require('./schemeConstant');
const { BaseSchema, whereNotDeleted } = require('../share.model');


const ScheduleSchema = BaseSchema(schemeConstants.Collection, {
    restaurantId: mongoose.Schema.Types.ObjectId,
    periods: [{
        dayOfWeeks: { type: Number },
        openAt: { type: Date },
        closeAt: { type: Date }
    }]
});

ScheduleSchema.pre('findOne', whereNotDeleted);

module.exports = mongoose.model(schemeConstants.Model, ScheduleSchema);