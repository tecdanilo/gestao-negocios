angular.module('gestao-negocio-app').controller('IndexController', function ($scope, $rootScope, $location, $routeParams, ContasPagarService, FilialService, FornecedorService) {

    $scope.mode = "insert";
    $scope.filiais = [];
    $scope.fornecedores = [];
    $scope.filialSelecionada = {};
    $scope.fornecedorSelecionado = {};
    $scope.contas = [];
    $scope.conta = {};
    $scope.dataVencimento;
    $scope.saldo = 0;

    $scope.filialFiltro = 0;

    $scope.comboFilialChange = function(){
        $scope.listAllContas($scope.filialFiltro);
    }

    $scope.listAllContas = function (id) {
        ContasPagarService.findAll(id).then(
            function(data){
                $scope.contas = data.data;
                $scope.calculaSaldo();
            },
            function (error) {
                console.error("Erro");
            }
        );
    }

    $scope.listAllFiliais = function(){
        FilialService.findAll().then(
            function(data){
                $scope.filiais = data.data;
            },
            function(error) {
                console.error("Erro");
            }
        );
    }

    $scope.listAllFornecedores = function(){
        FornecedorService.findAll().then(
            function(data){
                $scope.fornecedores = data.data;
            },
            function(error) {
                console.error("Erro");
            }
        );
    }

    $scope.novo = function () {
        console.log("Novo ");
        $scope.mode = 'insert';
        $scope.resetCadastro();

    }

    $scope.baixar = function (id) {
        console.log("baixa " + id);
        ContasPagarService.find(id).then(
            function (data) {
                $scope.conta = data.data;
                $scope.conta.dataBaixa = new Date().getTime();
                ContasPagarService.update($scope.conta).then(
                    function(){
                        console.info("baixa efetuada");
                        $scope.listAllContas($scope.filialFiltro);
                    },
                    function (error) {
                        console.error("erro ao efetuar baixa");
                    }
                );
            },
            function(error) {
                console.error("Erro");
            }
        );
    }

    $scope.editar = function (id) {
        console.log("editar " + id);
        $scope.resetCadastro();
        $scope.mode = "edit";
        ContasPagarService.find(id).then(
            function (data) {
                $scope.conta = data.data;
                $scope.dataVencimento = new Date($scope.conta.dataVencimento);
                for (var i = 0; i < $scope.fornecedores.length ; i++){
                    if ($scope.fornecedores[i].id == $scope.conta.fornecedorId){
                        $scope.fornecedorSelecionado = $scope.fornecedores[i];
                        break;
                    }
                }
                for (var j = 0; j < $scope.filiais.length ; j++){
                    if ($scope.filiais[j].id == $scope.conta.filialId){
                        $scope.filialSelecionada = $scope.filiais[j];
                        break;
                    }
                }


            },
            function(error) {
                console.error("Erro");
            }
        );
    }

    $scope.excluir = function (id) {
        console.log("excluir " + id);
        ContasPagarService.remove(id).then(
            function (data) {
                $scope.listAllContas($scope.filialFiltro);
                $scope.resetCadastro();
            },
            function(error) {
                console.error("Erro");
            }
        );
    }

    $scope.salvar = function () {
        console.log("salvar ");

        $scope.conta.dataVencimento = $scope.dataVencimento.getTime();
        if ($scope.filialSelecionada.id == undefined){
            $scope.conta.filialId = $scope.filialSelecionada;
        }else{
            $scope.conta.filialId = $scope.filialSelecionada.id;
        }
        if ($scope.fornecedorSelecionado.id == undefined){
            $scope.conta.fornecedorId = $scope.fornecedorSelecionado;
        }else{
            $scope.conta.fornecedorId = $scope.fornecedorSelecionado.id;
        }

        if ($scope.conta.id == null){
            ContasPagarService.create($scope.conta).then(
                function(data){
                    console.log("Gravado com sucesso");
                    $scope.listAllContas($scope.filialFiltro);
                    $scope.resetCadastro();
                },
                function(error){
                    console.error("Erro")
                }
            );
        }else{
            ContasPagarService.update($scope.conta).then(
                function(data){
                    console.log("Gravado com sucesso");
                    $scope.listAllContas($scope.filialFiltro);
                    $scope.resetCadastro();
                },
                function(error){
                    console.error("Erro")
                }
            );
        }
    }
    $scope.cancelar = function () {
        console.log("cancelar ");
        $scope.resetCadastro();
    }




    $scope.resetCadastro = function(){
        $scope.fornecedorSelecionado = {};
        $scope.filialSelecionada = {};
        $scope.conta = {
            "numdoc": null,
            "filialId": null,
            "fornecedorId": null,
            "dataLancamento": null,
            "dataVencimento": null,
            "valor": 0,
            "descricao": "",
            "observacao": "",
            "dataBaixa": null,
            "usuarioLancamentoId": null,
            "usuarioBaixaId": null
        };
    }

    $scope.calculaSaldo = function () {
        $scope.saldo = 0;
        for (var i = 0 ; i < $scope.contas.length ; i++){
            if ($scope.contas[i].dataBaixa == null){
                $scope.saldo += $scope.contas[i].valor;
            }
        }
    }

    $scope.init = function (){
        $scope.resetCadastro();
        $scope.listAllContas($scope.filialFiltro);
        $scope.listAllFiliais();
        $scope.listAllFornecedores();
    }
    $scope.init();

});