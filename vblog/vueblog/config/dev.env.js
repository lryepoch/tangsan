'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"'

  // NODE_ENV: '"development"',
  // // BASE_API: '"http://172.17.0.206:9000"';, //a
  // BASE_API: '"http://172.21.53.37:8100"';, //b
  // Base_url: '"http://172.21.53.37:8080"'; //前台地址,//用于window.location.href前台跳转到登录页
})
