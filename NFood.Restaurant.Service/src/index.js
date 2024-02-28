const express = require('express');
const cookieParser = require('cookie-parser');
const logger = require('morgan');
const cors = require('cors')
const bodyParser = require('body-parser');
const app = express();
const { logRequest, logError } = require('./middlewares/loggingMiddleware');
const { configureMongoDb } = require('./config/mongodb');
const { connectRedisDb } = require('./config/redis');
const restaurantRoute = require('./public-routes/restaurant.route');
const registerRoute = require('./public-routes/register.route');
const profileRoute = require('./public-routes/profile.route');
const scheduleRoute = require('./public-routes/schedule.route');
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

