const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const cors = require('cors')
const bodyParser = require('body-parser');
const app = express();
const { logRequest, logError } = require('./middlewares/loggingMiddleware');
const { configureMongoDb } = require('./config/mongodb');
const restaurantRoute = require('./routes/restaurant.route');
const { connectRedisDb } = require('./config/redis');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(cors());

app.use(logRequest);
app.use('/rating-api/', restaurantRoute);
app.use(logError);

app.listen(1500, () => {
    configureMongoDb();
    connectRedisDb();
    console.log(`App is listening on port ${1500}.`)
})

