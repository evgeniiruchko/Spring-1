angular.module('cart', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/shop';

    $scope.deleteFromCart = function (id) {
        $http.delete(contextPath + "/api/v1/products" + id)
            .then (function (response) {
                $scope.fillTable();
            });
    }

    $scope.addToCart = function (id) {
        $http.post(contextPath + "/api/v1/cart", id)
            .then (function (response) {
                $scope.fillCart();
            });
    }

    $scope.getLength = function(obj) {
        return Object.keys(obj).length;
    }

    $scope.fillCart = function () {
        $http.get(contextPath + "/api/v1/cart")
            .then(function (response) {
                $scope.cartList = response.data;
            })
    }

    $scope.fillCart();
});