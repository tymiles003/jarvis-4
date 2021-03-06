/**
 * AlertController
 *
 * @module      :: Controller
 * @description	:: A set of functions called `actions`.
 *
 *                 Actions contain code telling Sails how to respond to a certain type of request.
 *                 (i.e. do stuff, then send some JSON, show an HTML page, or redirect to another URL)
 *
 *                 You can configure the blueprint URLs which trigger these actions (`config/controllers.js`)
 *                 and/or override them with custom routes (`config/routes.js`)
 *
 *                 NOTE: The code you write here supports both HTTP and Socket.io automatically.
 *
 * @docs        :: http://sailsjs.org/#!documentation/controllers
 */

module.exports = {

  'new' : function (req, res, next) {

    Area.find().done(function (err, ar) {
      Suggestion.find().done(function (err, sugg) {
        res.view({
          suggestions: sugg,
          areas: ar,
          priorities: [ 1, 2, 3, 4, 5 ]
        });
      });
    });

//    Filter by type
//    Suggestion.findByType(areas[0].name).done(function foundSuggestions(err, sugg){
//      if (err) return next (err);
//      suggestions = sugg;
//    });

  },
  
  create: function (req, res, next) {
      
    var alertObj = {
      name: req.param('name'),
      rules: req.param('rules'),
      area: req.param('area'),
      priority: req.param('priority'),
      suggestions: req.param('suggestions')
    };

    console.log('alert', alertObj);
    Alert.create(alertObj, function alertCreated(err, alert) {

      // If there's an error
      if (err) {
        console.log(err);
        req.session.flash = {
            err: err
        };

        // If error redirect back to sign-up page
        return res.redirect('/alert/new');
      }

      alert.save(function (err, alert) {
        if (err) return next(err);

        FileSystemServices.createFile({ name: alert.name, directory: '/tmp/', text: alert.rules });
        res.redirect('/alert/index');
      });
    });
  },
  
  show: function (req, res, next) {

    Alert.findOne(req.param('id'), function foundArea (err, alert){
        
        if (err) return next(err);
        if (!alert) return next();
        res.view({
            alert: alert
        });
    });
  },
  
  index: function(req, res, next) {
      
      // Get an array of all alerts in the Alert collection(e.g table)
      Alert.find(function foundArea (err, alerts) {
          if (err) return next(err);
          // pass the array down to the /views/index.ejs page
          res.view({
              alerts: alerts
          });
      });
  },
  
  edit: function (req, res, next) {
      
      // Find the alert from the name passed in via params
      Alert.findOne(req.param('id'), function foundAlert (err, alert) {
          
          if (err) return next(err);
          if (!alert) return next();
          
          res.view({
              alert: alert
          });
      }); 
  },
  
  // process the information from edit view
  update: function (req, res, next) {
      
      Alert.update(req.param('id'), alertObj, function alertUpdate(err) {
          if (err) {
            return res.redirect('/alert/edit/' + req.param('id'));
          }
          
          res.redirect('/alert/show/' + req.param('id'));
      });
  },
  
  destroy: function (req, res, next) {
      
    Alert.findOne(req.param('id'), function foundAlert(err, alert){
        
        if (err) return next(err);
        if (!alert) return next(res.i18n('alert').noExist);
        
        Alert.destroy(req.param('id'), function alertDestroyed(err){
            if (err) return next(err);
        });
        res.redirect('/alert');
    });
  }  
};
