app.value('urlBase', 'http://localhost:8080/clientes/');
app.controller("ClienteController", function ($http, urlBase) {
    var self = this;

    self.cliente = undefined;
    self.clientes = [];

    self.novo = function () {
        self.cliente = {};
    };

    self.salvar = function () {
        var metodo = 'POST'
        if (self.cliente.id) {
            metodo = 'PUT';
        }

        $http({
            method: metodo,
            url: urlBase,
            data: self.cliente
        }).then(function successCallback(response) {
            self.atualizarTabela();
        }, function errorCallback(response) {
            self.ocorreuErro();
        });
    };

    self.alterar = function (cliente) {
        self.cliente = cliente;
    };

    self.deletar = function (cliente) {

        self.cliente = cliente;

        $http({
            method: 'DELETE',
            url: urlBase + self.cliente.id,
        }).then(function successCallback(response) {
            self.atualizarTabela();
        }, function errorCallback(response) {
            self.ocorreuErro();
        });

    };

    self.ocorreuErro = function () {
        alert("Ocorreu um erro inesperado!");
    };

    self.atualizarTabela = function(){
        $http({
            method: 'GET',
            url: urlBase + 'lista'
        }).then(function successCallback(response) {
            self.clientes = response.data;
            self.cliente = undefined;
        }, function errorCallback(response) {
            self.ocorreuErro();
        });
    };

    self.activate = function(){
        self.atualizarTabela();
    }

    self.activate();

});