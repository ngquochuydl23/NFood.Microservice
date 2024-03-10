const axios = require('axios');
const logger = require('../logger');

const authenticate = async (token) => {
  return axios({
    method: "get",
    url: process.env.OAUTH2_END_POINT,
    headers: {
      "Content-Type": "application/json",
      'Accept': '*/*`',
      "Authorization": `Bearer ${token}`,
    }
  })
}

const authMiddleware = (req, res, next) => {
  var token;
  try {
    token = req.header('Authorization').replace('Bearer ', '')
  } catch (error) {
    return res
      .status(401)
      .send({
        errorMessage: 'Token not found',
        statusCode: 401
      })
  }
  authenticate(token)
    .then(res => {
      req.userId = res.data.result.user.id;
      req.token = token;
      next();
    })
    .catch(err => {
      // switch (err.response.data) {
      //   case UNAUTHORIZED:
      //   default:
      //     return dtos.HttpUnauthorized(res, "Unauthorized");
      // }
    })
}

module.exports = {
  authMiddleware
};