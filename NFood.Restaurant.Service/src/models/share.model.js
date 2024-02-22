const mongoose = require('mongoose');



function whereNotDeleted() {
  this.where({ isDeleted: false });
}

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

module.exports = { BaseSchema, whereNotDeleted }