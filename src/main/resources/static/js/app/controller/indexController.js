angular.module('gestao-negocio-app').controller('IndexController', function ($scope, $rootScope, $location, $routeParams, ContasPagarService) {

    $scope.mode = "list"
    $scope.contas = [];
    $scope.conta = {};

    $scope.listAll = function () {
        ContasPagarService.findAll().then(
            function(data){
                $scope.contas = data.data;
                console.info("ok");
            },
            function (error) {
                console.error("Erro");
            }
        );
    }


    $scope.init = function (){
        $scope.conta = {
            "numdoc": null,
            "filialId": null,
            "fornecedorId": null,
            "dataLancamento": null,
            "dataVencimento": null,
            "valor": 0.0,
            "descricao": null,
            "observacao": null,
            "dataBaixa": null,
            "usuarioLancamentoId": null,
            "usuarioBaixaId": null
        };
        $scope.listAll();
    }
    $scope.init();

});