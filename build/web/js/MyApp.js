var app = angular.module("MyApp",["ngRoute"]);
app.config(function ($routeProvider){
    $routeProvider
       .when("/",{
        templateUrl:"main.jsp"
    }).when("/login",{
        templateUrl:"login.jsp",
        controller:"LoginC"
    }).when("/addP",{
        templateUrl:"AddPerson.jsp",
        controller:"AddC"
    }).when("/check",{
        templateUrl:"Check_Detail.jsp",
        controller:"CheckC"
    });
});
app.controller("AddC", [ '$scope', '$http', function($scope, $http) {
 
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
    
    $scope.AddP = function() {
        $http({
            url : 'Add',
            method : "POST",
            data :$scope.newItem 
                
        }).then(function(response) {
            console.log(response.data);
            $scope.msg = response.data;
            $scope.newItem="";
            
        }, function(response) {
            console.log(response);
            $scope.msg = response;
        });
        
 
    };
    
} ]);
app.controller("CheckC", [ '$scope' , '$http' , function ($scope,$http){
        $scope.Item=[];
        $http.defaults.headers.get["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
        $scope.PDetail=function (){
        $http({
            url:'PDetail',
            method:'GET'
        }).success(function (data){
                //console.log(angular.fromJson(data.DATA));
                $scope.Array=angular.fromJson(data.DATA);
                for(var i=0;i<$scope.Array.length;i++)
                {
                    var a={"name":$scope.Array[i][0],
                    "age":$scope.Array[i][1],
                    "city":$scope.Array[i][2]};
                $scope.Item.push(a);
                }
                
        }).error (function (response){
            console.log(response);
            $scope.msg=response;
        });
    };
}]);