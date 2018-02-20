angular.module('gestao-negocio-app').config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'IndexController'
        })
        .otherwise({
            redirectTo: '/'
        });
});
