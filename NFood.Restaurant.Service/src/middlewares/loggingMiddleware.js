
const logger = require('../logger');

exports.logRequest = (req, res, next) => {
  logger.info(req.url);
  try {
    next();
  } catch (error) {
    next(error, req, res, next);
  }
}

exports.logError = (err, req, res, next) => {
  if (err) {
    //logger.error(err.message, err);
    return res.status(500)
      .send({
        statusCode: 500,
        errorMessage: err.message
      })
  }
  next();
} 
