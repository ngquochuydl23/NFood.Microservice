const { getHttp } = require('./base-external-service');
const { restaurantService } = require('./external-config');

function findUserById(jwtToken, id) {
    return getHttp(jwtToken, restaurantService).get('/user/' + id);
}

module.exports = {
    findUserById
}