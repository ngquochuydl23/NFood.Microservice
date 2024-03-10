const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const cors = require('cors')
const bodyParser = require('body-parser');
const app = express();
const { logRequest, logError } = require('./middlewares/loggingMiddleware');
const { configureMongoDb } = require('./config/mongodb');
const restaurantRoute = require('./routes/restaurant.route');
const registerRoute = require('./routes/register.route');
const { connectRedisDb } = require('./config/redis');
const { cli } = require('winston/lib/winston/config');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(cors());

app.use(logRequest);
app.use('/restaurant-api/', restaurantRoute);
app.use('/restaurant-api/', registerRoute);
app.use(logError);

app.listen(3000, () => {
    configureMongoDb();
    connectRedisDb();
    console.log(`App is listening on port ${3000}.`)
})

