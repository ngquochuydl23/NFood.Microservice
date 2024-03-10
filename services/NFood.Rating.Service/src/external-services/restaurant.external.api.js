const { getHttp } = require('./base-external-service');
const { restaurantService } = require('./external-config');

function findRestaurantById(jwtToken, id) {
    return getHttp(jwtToken, restaurantService).get('/restaurant/' + id);
}

module.exports = {
    findRestaurantById
}