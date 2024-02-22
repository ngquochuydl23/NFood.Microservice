const winston = require('winston');
const { SeqTransport } = require('@datalust/winston-seq');
const loggerConfig = require('./logger.config');

const logger = winston.createLogger({
  format: winston.format.combine(
    winston.format.errors({ stack: true }),
    winston.format.json(),
  ),
  defaultMeta: { application: loggerConfig.appName },
  transports: [
    new winston.transports.Console({
      format: winston.format.simple(),
    }),
    new SeqTransport({
      serverUrl: loggerConfig.serverUrl,
      apiKey: loggerConfig.apiKey,
      onError: (e => {
        // console.error(e)
      }),
      handleExceptions: true,
      handleRejections: true,
    })
  ]
});

module.exports = logger;