var app = angular.module("Myapp", ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/home', {
                templateUrl: 'views/home.html'
            })
        .when('/cliente', {
            templateUrl: 'views/listCliente.html',
            controller: "ClienteController"
        })
        .otherwise("/home");

});