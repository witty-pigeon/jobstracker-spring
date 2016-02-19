angular.module('JobsTrackerSpring')
        .controller('PositionsShowCtrl', ['$scope', '$routeParams', 'PositionResource',
          function ($scope, $routeParams, PositionResource) {
            'use strict';
            
            $scope.position = PositionResource.get({id: $routeParams.id});
          }]);