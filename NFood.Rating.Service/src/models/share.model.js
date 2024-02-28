const mongoose = require('mongoose');

const BaseSchema = (name, inheritSchema) => {
  return new mongoose.Schema(
    inheritSchema,
    {
      timestamps: true,
      collection: name,
      isDeleted: { type: Boolean, defaults: false }
    }
  );
}

module.exports = { BaseSchema }