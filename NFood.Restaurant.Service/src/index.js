const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const cors = require('cors')
const bodyParser = require('body-parser');
const app = express();
const { logRequest, logError } = require('./middlewares/loggingMiddleware');
const { configureMongoDb } = require('./config/mongodb');
const { connectRedisDb } = require('./config/redis');
const restaurantRoute = require('./routes/restaurant.route');
const registerRoute = require('./routes/register.route');
const profileRoute = require('./routes/profile.route');
const scheduleRoute = require('./routes/schedule.route');
const { RequestMapping } = require('./utils/requestMapping');


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(cors());

app.use(logRequest);
app.use(RequestMapping('restaurant'), restaurantRoute);
app.use(RequestMapping('register'), registerRoute);
app.use(RequestMapping('profile'), profileRoute);
app.use(RequestMapping('schedule'), scheduleRoute);
app.use(logError);

app.listen(1300, () => {
    configureMongoDb();
    connectRedisDb();
    console.log(`App is listening on port ${1300}.`);
})

