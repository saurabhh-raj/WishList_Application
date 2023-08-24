const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
app.use(
'/api',
createProxyMiddleware({
target: "http://localhost:9090",
changeOrigin: true,
pathRewrite: {
'^/api': ''

}
})
);
};

//api/wishlists -> server -> http://localhost:9090/wishlists
//
//http://localhost:9090/api/wishlists
