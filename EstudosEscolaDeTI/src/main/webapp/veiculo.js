module = angular.module("EstudosEscolaDeTI",[]);

module.controller("PessoaVeiculoController", ["$scope", "$http", PessoaVeiculoController]);

function PessoaVeiculoController($scope, $http) {
    $scope.iniciar = funcaoIniciar;
    $scope.salvar = funcaoSalvar;
    $scope.exluir = funcaoExcluir;
    $scope.editar = funcaoEditar;

    $scope.veiculo = {};
    $scope.veiculos = [];
    $scope.isNovo = true;

    function funcaoEditar(vitima) {
        $scope.veiculo = angular.copy(vitima);
        $scope.isNovo = false;
    }

    function funcaoExcluir(vitima) {
        $http.delete("/veiculos/" + vitima.id).success(onSuccess).error(onError);
        function onSuccess(data, status) {
            console.log(data);
            funcaoCarregar();
        }
        function onError(data, status) {
            alert("Deu erro" + data);

        }
    }

    function funcaoSalvar() {
        if ($scope.isNovo) {
            $http.post("/veiculos", $scope.veiculo).success(onSuccess).error(onError);
        } else {
            $http.put("/veiculos", $scope.veiculo).success(onSuccess).error(onError);
        }
        function onSuccess(data, status) {
            console.log(data);
            funcaoCarregar();
            $scope.veiculo = {};
            $scope.isNovo = true;
        }
        function onError(data, status) {
            alert("Deu erro" + data);

        }
    }
    
    function funcaoCarregar(){
        $http.get("/veiculos").success(onSuccess).error(onError);
        
        function onSuccess(data, status) {
            $scope.veiculos = data;
            console.log(data);
        }
        function onError(data, status) {
            alert("Deu erro" + data);

        }
    }
    
    function funcaoIniciar(){
        console.log("Iniciando");
        funcaoCarregar();
        console.log("Veiculos carregadas");
        
    }
    

}

