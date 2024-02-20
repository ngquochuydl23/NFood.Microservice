const express = require('express');
const router = express.Router();



router.get('/register/', (req, res) => {
    try {
        res.send(req.params.id)
    } catch (error) {
        console.log(err)
    }
})

module.exports = router;
