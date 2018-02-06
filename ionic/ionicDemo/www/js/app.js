// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services'])
  .constant('API_URL', 'http://localhost:9090/mobile/')
  .constant('REQUEST', {
    'ORDER_LIST': 'getOrderList',
    'ORDER_DETAIL': 'getOrderDetail'
  })

  .constant('SESSION_OVERTIME', 7200)
  .constant('TOKEN', 'c56119c395545b4bb60aaf6e22f77a22')

  .run(function ($rootScope,$ionicPlatform,$location,$state,$stateParams,$ionicHistory,$ionicNavBarDelegate,$window,Session,Local,PopModel) {
    $ionicPlatform.ready(function () {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)
      if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
        cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        cordova.plugins.Keyboard.disableScroll(true);

      }
      if (window.StatusBar) {
        // org.apache.cordova.statusbar required
        StatusBar.styleDefault();
      }
    });
  })

  .config(function ($stateProvider, $urlRouterProvider) {

    // Ionic uses AngularUI Router which uses the concept of states
    // Learn more here: https://github.com/angular-ui/ui-router
    // Set up the various states which the app can be in.
    // Each state's controller can be found in controllers.js
    $stateProvider

    // setup an abstract state for the tabs directive
      .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'templates/main.html'
      })

      // Each tab has its own nav history stack:

      .state('app.home', {
        url: '/home',
        views: {
          'home': {
            templateUrl: 'templates/home.html',
            controller: 'HomeCtrl'
          }
        }
      })

      .state('app.orders', {
        url: '/orders',
        cache:false,
        views: {
          'orders': {
            templateUrl: 'templates/orders.html',
            controller: 'OrdersCtrl'
          }
        }
      })

      .state('app.user', {
        url: '/user',
        views: {
          'user': {
            templateUrl: 'templates/user.html',
            controller: 'UserCtrl'
          }
        }
      })

      .state('app.orderdetail', {
        url: '/orderdetail/:orderNo',
        views: {
          'orders': {
            templateUrl: 'templates/orders/orderdetail.html',
            controller: 'OrderDetailCtrl'
          }
        }
      });

    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/app/home');

  });
