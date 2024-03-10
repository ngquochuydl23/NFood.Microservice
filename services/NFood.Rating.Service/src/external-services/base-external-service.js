const axios = require('axios');
const _ = require('lodash')

function getHttp(jwtToken, config) {

    const http = axios.create({ baseURL: config.baseUrl });

    http.interceptors.request.use(
        (config) => {

            config.headers['Authorization'] = 'Bearer ' + jwtToken;
            config.headers['Content-Type'] = `application/json-patch+json`;
            config.headers['accept'] = `*/*`;

            return config;
        },
        (error) => {
            console.log(error)
            return Promise.reject(error);
        });

    http.interceptors.response.use(
        (response) => {
            return response.data.result;
        },
        (error) => {
            if (_.has(error, 'response.data.error')) {

                const resError = _.get(error, 'response.data.error')
                console.log("http.interceptors.response", { resError })
                const dispatch = _.get(global, 'dispatch')
                //dispatch?.(globalErrorActions.pushResponseError(resError))
                return Promise.reject(resError)
            }
            return Promise.reject(error);
        });

    return http;
}


module.exports = { getHttp }



