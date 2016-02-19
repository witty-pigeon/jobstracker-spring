angular.module('JobsTrackerSpring')
        .factory('positionResource', ['$resource', 'contextInfoSvc',
          function ($resource, contextInfoSvc) {
            
            var context = contextInfoSvc.getContext();
            
            return $resource( context + 'api/positions/');
            
          }]);