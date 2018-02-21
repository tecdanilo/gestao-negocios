'use strict';

angular.module('gestao-negocio-app').factory('FilialService', function($http, $q, BACKEND){

    return {

        findAll: function() {
            var url = BACKEND+'filial/list';
            return $http.get(url)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error fetching data from ' + url);
                        return $q.reject(errResponse);
                    }
                );
        }

    };

});





