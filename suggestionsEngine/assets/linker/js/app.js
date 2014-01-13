/**
 * app.js
 *
 * This file contains some conventional defaults for working with Socket.io + Sails.
 * It is designed to get you up and running fast, but is by no means anything special.
 *
 * Feel free to change none, some, or ALL of this file to fit your needs!
 */


(function (io) {

  // as soon as this file is loaded, connect automatically, 
  var socket = io.connect();
  if (typeof console !== 'undefined') {
    log('Connecting to Sails.js...');
  }

  socket.on('connect', function socketConnected() {

    // Listen for Comet messages from Sails
    socket.on('message', cometMessageReceivedFromServer);
    
    // Subscribe to the user model classroom and instance room
    socket.get('/user/subscribe');


    ///////////////////////////////////////////////////////////
    // Here's where you'll want to add any custom logic for
    // when the browser establishes its socket connection to 
    // the Sails.js server.
    ///////////////////////////////////////////////////////////
    log(
        'Socket is now connected and globally accessible as `socket`.\n' + 
        'e.g. to send a GET request to Sails, try \n' + 
        '`socket.get("/", function (response) ' +
        '{ console.log(response); })`'
    );
    ///////////////////////////////////////////////////////////


  });


  // Expose connected `socket` instance globally so that it's easy
  // to experiment with from the browser console while prototyping.
  window.socket = socket;


  // Simple log function to keep the example simple
  function log () {
    if (typeof console !== 'undefined') {
      console.log.apply(console, arguments);
    }
  }
  

})(

  // In case you're wrapping socket.io to prevent pollution of the global namespace,
  // you can replace `window.io` with your own `io` here:
  window.io

);

// This function routes the message based upon the model which issued it
function cometMessageReceivedFromServer(message) {
    
    console.log("Here's the message: ", message);
    
    // Ok, I need route this message to the appropiate place.
    
    // This message has to do with the User Model
    if ( message.model === 'user' ) {
        var userId = message.id;
        updateUserInDom(userId, message);
    }
}

function updateUserInDom(userId, message) {
    
    // What page am I on?
    var page = document.location.pathname;
    
    // Strip trailing slash if we've got one
    page = page.replace(/(\/)$/, '');
    
    // Route to the appropiate user update handler based on which page you're on
    switch (page) {
        
        // If we're on the User administration Page (a.k.a. user index)
        case '/user':
            
            // This is a message coming from publishUpdate
            if (message.verb === 'update') {
                UserIndexPage.updateUser(userId, message);
            }
            // This is a message comming from publishCreate
            if (message.verb === 'create') {
                UserIndexPage.addUser(message);
            }
            // This is a message comming publishDestroy
            if (message.verb === 'destroy') {
                UserIndexPage.destroyUser(userId);
            }
            break;
    }
}


// User index page DOM manipulation logic
// (i.e. backbone-style view)
var UserIndexPage = {
    
    // Update the User, in this case their login status
    updateUser: function (id, message) {
        if (message.data.loggedIn) {
            var $userRow = $('tr[data-id="' + id + '"] td img').first();
            $userRow.attr('src', "/images/icon-online.png");
        } else {
            var $userRow = $('tr[data-id="' + id + '"] td img').first();
            $userRow.attr('src', "/images/icon-offline.png");
        }
    },
    
    // Add an user to the list of users in the User Administration page
    addUser: function (user) {
        // obj is going to emcompass both the new user data as well as the _csrf info room
        // the layout.js file
        var obj = {
            user: user.data,
            _csrf: window.jarvis.csrf || ''
        };
        
        // Add the template to the bottom of the User Administration Page
        $( 'tr:last' ).after(
                    // This is the path to the templates file
                    JST['assets/linker/templates/addUser.ejs']( obj )
                );
    },
    destroyUser: function(id) {
        
        $('tr[data-id="' + id + '"]').remove();
    }
};