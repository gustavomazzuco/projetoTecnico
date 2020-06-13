app.controller("EnderecoController", function ($http) {

    var self = this;

    self.endereco = undefined;
    self.enderecos = [];

    self.novo = function () {
        self.endereco = {};
    };

})