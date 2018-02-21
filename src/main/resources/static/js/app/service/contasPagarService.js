'use strict';

angular.module('gestao-negocio-app').factory('ContasPagarService', function($http, $q, BACKEND){

    return {

        findAll: function(id) {
            var url = BACKEND+'contas/pagar/list/';
            if (id != undefined && id > 0){
                url+='?filialId='+id;
            }
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
        },

        find: function(id){
            var url = BACKEND+'contas/pagar/'+id;
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
        },

        create: function(obj){
            var url = BACKEND+'contas/pagar/';
            return $http.post(url, obj)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error fetching data from ' + url);
                        return $q.reject(errResponse);
                    }
                );
        },

        update: function(obj){
            var url = BACKEND+'contas/pagar/';
            return $http.put(url, obj)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error fetching data from ' + url);
                        return $q.reject(errResponse);
                    }
                );
        },

        remove: function(id){
            var url = BACKEND+'contas/pagar/'+id;
            return $http.delete(url)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error fetching data from ' + url);
                        return $q.reject(errResponse);
                    }
                );
        },




    };

});





