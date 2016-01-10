var app = angular.module('MyApp', [])

        .controller("MyCtrl", function($http){
            var self = this;
            self.members = {};
            self.populate = function(){
                $http({
                    method: "GET",
                    url: "api/members",
                    contentType: "application/json"
                })
                        .success(function(data){
                            self.members = data;
                        })
                        .error(function(){
                            alert("Sth went wrong.");
                        });
            };
        });