angular.module('JobsTrackerSpring')
        .factory('PositionResource', ['$resource', 'contextInfoSvc',
          function ($resource, contextInfoSvc) {
            
            var context = contextInfoSvc.getContext();
            
            var additionalActions = {
              update: {method: 'PUT'}
            };
            
            return $resource( context + 'api/positions/:id', {id: '@id'}, additionalActions);
            
          }]);