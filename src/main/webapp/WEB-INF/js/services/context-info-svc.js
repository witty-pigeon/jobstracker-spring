angular.module('JobsTrackerSpring')
        .factory('contextInfoSvc', function(){
          
          function getContext() {
            // angular doesn't play nice with head tags without JQuery
            var contextMeta = document.querySelector('meta[name=_context]');
            var context = angular.element(contextMeta).attr('content');
            
            return context;
          }
          
          return {
            getContext: getContext
          };
        });