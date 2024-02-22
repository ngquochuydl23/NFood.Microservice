const express = require('express');
const router = express.Router();
//const auth = require('../config/oauth2');

// middleware that is specific to this router
// router.use((req, res, next) => {
//     console.log('Time: ', Date.now())
//     next()
// })


// define the home page route
router.get('/restaurant/:id', (req, res) => {
    try {
        res.send(req.params.id)
    } catch (error) {
        console.log(err)
    }
})


module.exports = router;