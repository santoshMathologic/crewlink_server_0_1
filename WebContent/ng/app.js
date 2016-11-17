' use strict';


 var api = {
    protocol: 'http',
    server: 'localhost',
    port: 4000,
    baseUrl: '/api/v1',
    loginUrl: '/login',
 };

 var apiUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl;
 
 var apiLoginUrl = api.protocol + '://' + api.server + ':' + api.port + api.loginUrl;
  

angular.module("smartWebApp",[
	  'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'toaster',
    'ngCookies',
    'smart-table',
    'ngResource',
    'base64',
    'angularjs-dropdown-multiselect'
	]).factory('TokenInterceptor', function($q, $window,$location) {
    return {
        request: function(config) {
          config.headers = config.headers || {};
          if ($window.sessionStorage.token) {
            config.headers['X-Access-Token'] = $window.sessionStorage.token;
            config.headers['X-Key'] = $window.sessionStorage.user;
            config.headers['Content-Type'] = config.headers['Content-Type'] || "application/json";
          }
          return config || $q.when(config);
        },
     
        response: function(response) {
          if(response.status === 401 || response.status === 403) {
                  $location.path('/login');
              }
          return response || $q.when(response);
        }
      };
    })
.config(['$stateProvider','$urlRouterProvider','$ocLazyLoadProvider',function($stateProvider,$urlRouterProvider,$ocLazyLoadProvider){

	 // $httpProvider.defaults.useXDomain = true;
	 // delete $httpProvider.defaults.headers.common['X-Requested-With'];
	 // $httpProvider.defaults.headers.common["Accept"] = "application/json";
	 // $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
	    
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });
     $urlRouterProvider.otherwise('/home/dashboard');
     $stateProvider
     .state('home',{
        url:'/home',
        templateUrl:'ng/directives/home/home.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
                    'ng/directives/home/home.js',
                   
              ]
            });
          }
        }
      })
      .state('home.dashboard',{
        url:'/dashboard',
        templateUrl:'ng/directives/dashboard/dashboard.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/dashboard.js',
              'ng/directives/dashboard/sidebar/sidebar.js',
              'ng/directives/dashboard/header/header.js',
              'ng/directives/dashboard/footer/footer.js',
              'ng/utils/customConverter.js',
              'ng/utils/serverTableFetch.js',
              'ng/factory/auth.js'
                
                
              ]
            });
          }
        }
      })
      .state('home.dashboard.userPlan',{
        url:'/plan',
        templateUrl:'ng/directives/dashboard/userPlan/userPlan.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/userPlan/userPlan.js'
              ]
            });
          }
        }
      }).state('home.dashboard.user',{
        url:'/user',
        templateUrl:'ng/directives/dashboard/user/user.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/user/user.js'
              ]
            });
          }
        }
      }).state('home.dashboard.trains',{
        url:'/train',
        templateUrl:'ng/directives/dashboard/trains/train.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/directives/dashboard/trains/train.js'
              ]
            });
          }
        }
      })
      .state('login',{
        url:'/login',
        templateUrl:'ng/directives/login/login.directive.html',
        controller:"loginCtrl",
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/controller/login.js',
              'ng/directives/login/login.js',
               'ng/factory/auth.js'
              ]
            });
          }
        }
      })
      .state('register',{
        url:'/register',
        templateUrl:'ng/directives/register/register.directive.html',
        controller:"registerCtrl",
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'smartWebApp',
              files:[
              'ng/controller/register.js',
              'ng/directives/register/register.js'
               
              ]
            });
          }
        }
      });
  
	
             console.log("in app");

	}]);

