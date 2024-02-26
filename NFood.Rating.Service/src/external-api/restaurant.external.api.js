const { getHttp } = require('./base-external-api');
const { restaurantService } = require('./external-config');



function findRestaurantById(req, id) {
    return getHttp(req, restaurantService).get('/restaurant/' + id);
}

module.exports = {
    findRestaurantById
}