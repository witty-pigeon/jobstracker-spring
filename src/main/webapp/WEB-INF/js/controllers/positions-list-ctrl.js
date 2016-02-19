angular.module('JobsTrackerSpring')
        .controller('PositionsListCtrl', ['$scope', 'PositionResource',
          function ($scope, PositionResource) {
            
            'use strict';
            
            $scope.salaryCheck = function(position) {
              if(position.salaryMin == 0) return 'NONE';
              if((position.salaryMin != 0) && (position.salaryMin < position.salaryMax)) return 'BOTH';
              else return 'MIN';
            };
            
            var positions = PositionResource.query(function(){
              $scope.positions = positions;
            });
          }]);