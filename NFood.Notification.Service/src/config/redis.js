const { createClient } = require('redis');


const client = createClient({ url: process.env.REDIS_URL, no_ready_check: true })

module.exports = {
    client,
    connectRedisDb() {
        return new Promise((resolve, reject) => {
            client
                .connect()
                .then(() => {
                    console.log("Redis has connected succesfully");
                    resolve();
                })
                .catch((err) => {
                    console.log(err);
                    reject();
                })
        })
    }
}