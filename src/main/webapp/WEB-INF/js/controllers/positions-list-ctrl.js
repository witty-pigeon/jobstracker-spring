angular.module('JobsTrackerSpring')
        .controller('PositionsListCtrl', ['$scope', 'positionResource', 'contextInfoSvc',
          function ($scope, positionResource, contextInfoSvc) {
            
            'use strict';
            
            $scope.context = contextInfoSvc.getContext();
            $scope.salaryCheck = function(position) {
              if(position.salaryMin == 0) return 'NONE';
              if((position.salaryMin != 0) && (position.salaryMin < position.salaryMax)) return 'BOTH';
              else return 'MIN';
            };
            
            var positions = positionResource.query(function(){
              $scope.positions = positions;
            });
          }]);