angular.module('JobsTrackerSpring')
        .controller('PositionsNewCtrl', ['$scope', '$location', 'positionResource',
          function ($scope, $location, positionResource) {
            'use strict';

            $scope.submitLabel = 'Create';
            $scope.position = {};

            $scope.submit = function () {
              if ($scope.positionForm.$valid) {
                positionResource.save($scope.position,
                        function (data) {
                          $scope.$emit('successMessage', 'Saved');
                          $location.path('/positions/');
                        },
                        function (err) {
                          $scope.emit('errorMessage', 'Error while saving: ' + err);
                        });
              }
            };



          }]);