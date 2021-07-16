angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/shop';

    //создаём функцию с именем fillTable
    $scope.fillTable = function () {
        $http({
            url: contextPath + '/api/v1/products',
            method: 'GET',
            params: {
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
                console.log(response);
                $scope.ProductsList = response.data;
            });
    };

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    };

    $scope.deleteProductById = function (id) {
        $http.delete(contextPath + "/products/" + id)
            .then (function (response) {
                $scope.fillTable();
            });
    }

    $scope.fillTable();
});