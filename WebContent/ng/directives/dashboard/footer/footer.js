angular.module('smartWebApp')
    .directive('footer', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/footer/footer.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window) {
            	console.log("Inside footer");
              
                
            }

        };
    }]);