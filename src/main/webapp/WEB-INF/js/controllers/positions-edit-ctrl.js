angular.module('JobsTrackerSpring')
        .controller('PositionsEditCtrl', ['$scope', '$location', '$routeParams', 'PositionResource',
          function ($scope, $location, $routeParams, PositionResource) {
            'use strict';

            $scope.submitLabel = 'Update';
            $scope.position = PositionResource.get({id: $routeParams.id});

            $scope.submit = function () {
              if ($scope.positionForm.$valid) {
                PositionResource.update(
                          {id: $scope.position.id},
                          $scope.position
                        ).$promise.then(
                        function (data) {
                          $scope.$emit('successMessage', 'Saved ' + $scope.position.position);
                          $location.path('/positions/' + $scope.position.id);
                        },
                        function (err) {
                          $scope.emit('errorMessage', 'Error while saving: ' + err);
                        });
              }
            };



          }]);