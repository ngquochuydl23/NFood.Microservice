const { getHttp } = require('./base-external-service');
const { restaurantService } = require('./external-config');



function findRestaurantById(req, id) {
    return getHttp(req, restaurantService).get('/restaurant/' + id);
}

module.exports = {
    findRestaurantById
}