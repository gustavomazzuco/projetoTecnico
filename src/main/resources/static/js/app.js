var app = angular.module("Myapp", ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/cliente', {
            templateUrl: 'views/listCliente.html',
            controller: "ClienteController"
        })
        .otherwise("/");

});