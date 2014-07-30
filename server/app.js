'use strict';
var config = require('./config');
var database = require('./services/database');
var express = require('express');
var mongoose = require('mongoose');
var socket = require('socket.io');
var app = express();
module.exports = app;
mongoose.connect('mongodb://'+config.db.host + ':' + config.db.port +'/' + config.db.name);

function main () {
  var http = require('http');
  var bodyParser = require('body-parser');
  var cookieParser = require('cookie-parser');
  var session = require('express-session');

  //Configure the application
  app.use(express.static(__dirname + config.public));
  app.use(bodyParser());
  // Session handler
  app.use(cookieParser());
  app.use(session({ secret: 'S3CRE7', cookie: { secure: true } } ));

  app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
    res.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");
    next();
  });

  var server = http.createServer(app);

  // Load all routes
  require('./routes')(app);

  // Listen on http port
  server.listen(config.port);
  var io = socket.listen(server);

  // users connections
  app.connections = {};

  io.sockets.on('connection', function (socket) {
    console.log("connect");
    socket.on('username', function(username) {
      app.connections[username] = socket;
      socket.emit('message', { message: 'Welcome ' + username + ' to JARVIS' });
    });
    socket.on('disconnect', function (socket) {
      console.log("disconnect");
    });

    socket.on('message', function (data) {
      console.log("client: ", data);
    });
  });
}

main();