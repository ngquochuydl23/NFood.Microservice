const { auth } = require('express-oauth2-jwt-bearer');

module.exports = auth({
    issuer: 'http://localhost',
    audience: 'NFood',
    secret: '1qaz2wsx3edc4rfv',
})