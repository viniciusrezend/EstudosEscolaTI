module = angular.module(Pessoa, []);

module.controller("PessoaController", ["$scope", "$http", PessoaController]);

function PessoaController($scope, $http) {
    $scope.iniciar = funcaoIniciar;
    $scope.salvar = funcaoSalvar;
    $scope.exluir = funcaoExcluir;
    $scope.editar = funcaoEditar;

    $scope.pessoa = {};
    $scope.pessoas = [];
    $scope.isNovo = true;

    function funcaoEditar(vitima) {
        $scope.pessoa = angular.copy(vitima);
        $scope.isNovo = false;
    }

    function funcaoExcluir(vitima) {
        $http.delete("/pessoas/" + vitima.registro).success(onSuccess).error(onError);
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
            $http.post("/pessoas", $scope.pessoa).success(onSuccess).error(onError);
        } else {
            $http.put("/pessoas", $scope.pessoa).success(onSuccess).error(onError);
        }
        function onSuccess(data, status) {
            console.log(data);
            funcaoCarregar();
            $scope.pessoa = {};
            $scope.isNovo = true;
        }
        function onError(data, status) {
            alert("Deu erro" + data);

        }
    }
    
    function funcaoCarregar(){
        $http.get("/pessoas").success(onSuccess).error(onError);
        
        function onSuccess(data, status) {
            $scope.pessoas = data;
            console.log(data);
        }
        function onError(data, status) {
            alert("Deu erro" + data);

        }
    }
    
    function funcaoIniciar(){
        console.log("Iniciando")
        funcaoCarregar();
        console.log("Pessoas carregadas")
        
    }

}

