'use strict';
angular.module('JobsTrackerSpring',['ui.bootstrap', 'ngRoute', 'ngResource'])
        .config(['$routeProvider', '$locationProvider', '$resourceProvider',
            function($routeProvider, $locationProvider, $resourceProvider) {
              $locationProvider.html5Mode(false);
              // Don't strip trailing slashes from calculated URLs for ngResources
              $resourceProvider.defaults.stripTrailingSlashes = false;
              
              $routeProvider
                      .when('/home', {
                        templateUrl: '../resources/ng-views/home.html',
                        controller: 'HomeCtrl'
                      })
                      .when('/positions', {
                        templateUrl: '../resources/ng-views/positions/list.html',
                        controller: 'PositionsListCtrl'
                      })
                      .when('/positions/new', {
                        templateUrl: '../resources/ng-views/positions/form.html',
                        controller: 'PositionsNewCtrl'
                      })
                      .when('/positions/:id', {
                        templateUrl: '../resources/ng-views/positions/show.html',
                        controller: 'PositionsShowCtrl'
                      })
                      .when('/positions/:id/edit', {
                        templateUrl: '../resources/ng-views/positions/form.html',
                        controller: 'PositionsEditCtrl'
                      })
                      .otherwise({redirectTo: '/home'});
            }])
          
          
          
        .run(['$rootScope', '$timeout', '$http', function($rootScope, $timeout, $http){
            'use strict';
    
            // How long before a message expires (in milliseconds)
            var MESSAGE_TTL = 20000;
    
            $rootScope.messages = [];
            
            $rootScope.removeMessage = function(index) {
              $rootScope.messages.splice(index, 1);
            };
    
    
            function pushMessage(message, type) {
              $rootScope.messages.push({type: type, message: message, timeLong: Date.now()});
            }
            
            function isMessageNotExpired(message) {
              return Date.now() - message.timeLong < MESSAGE_TTL;
            }
            
            function purgeExpired() {
              if($rootScope.messages.length) {
                $rootScope.messages = $rootScope.messages.filter(isMessageNotExpired);
                $timeout(purgeExpired, 400);
              }
            }
            
            /* creates listener for
             * errorMessage,
             * warningMessage,
             * infoMessage,
             * successMessage
             */
            ['error', 'warning', 'info', 'success'].forEach(function(type){
              var evtType = type+'Message';
              $rootScope.$on( evtType, function(event, data){
                pushMessage(data, type);
                purgeExpired();
              });
            });
            
            
            
            
        }]);