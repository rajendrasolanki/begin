var app = angular.module("MyApp",["ngRoute"]);
app.config(function ($routeProvider){
    $routeProvider
       .when("/",{
        template:"<h1>Welcome</h1>"
    }).when("/login",{
        templateUrl:"login.jsp",
        controller:"LoginC"
    }).when("/signup",{
        templateUrl:"Signup.jsp",
        controller:"SignUpC"
    }).when("/addP",{
        resolve:{
            "check":function($rootScope,$location){
                if(!$rootScope.Login)
                {
                    $location.path("/");
                }
            }
        },
        templateUrl:"AddPerson.jsp",
        controller:"AddC"
    }).when("/check",{
        resolve:{
            "check":function($rootScope,$location){
                if(!$rootScope.Login)
                {
                    $location.path("/");
                }
            }
        },
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
            //console.log(response.data);
            $scope.msg = response.data;
            $scope.newItem="";
            
        }, function(response) {
            console.log(response);
            $scope.msg = response;
        });
        
 
    };
    
} ]);
app.controller("CheckC", [ '$scope' , '$http' , function ($scope,$http){
        
         $scope.PDetail=function (){
        $http({
            url:'PDetail',
            method:'GET'
        }).success(function (data){
            
                $scope.Item=angular.fromJson(data.DATA);
            
        }).error (function (response){
            console.log(response);
            $scope.msg=response;
        });
    };
       //  $http.defaults.headers.get["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
       
        $scope.Remove=function (x){
            $scope.id=x;
            $http({
            url : 'Delete',
            method : "POST",
            data :$scope.id
                
        }).then(function(response) {
            //console.log(response.data);
            $scope.PDetail();
        }, function(response) {
            console.log(response);
        });
        
    };
            }]);
app.controller("LoginC", function ($scope,$rootScope,$http){
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";    
    $scope.Login=function (){
            $http({
            url : 'Login',
            method : "POST",
            data :$scope.User 
                
        }).then(function(response) {
            
            if (response.data === "1")
            {
                $rootScope.Login=true;
            }else
            {
                $rootScope.Login=false;
            }
            //console.log($rootScope.Login+response.data);
            $scope.User="";
            
        }, function(response) {
            console.log(response);
        });
        
    };
} );
app.controller("SignUpC", [ '$scope', '$http', function($scope, $http) {
 
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
    $scope.newUser={};
    $scope.SignUp = function() {
        if($scope.newUser.pass === $scope.newUser.pass1){
        $http({
            url : 'Signup',
            method : "POST",
            data :$scope.newUser 
                
        }).then(function(response) {
            console.log(response.data);
            if(response.data !== "")
                $scope.msg = "Success";
            else
                $scope.msg="Unsuccess";
            console.log($scope.msg);
            $scope.newUser="";
            
        }, function(response) {
            console.log(response);
            $scope.msg = response;
        });
        
        }
        else
        {  
           $scope.msg="Password not match"; 
           $scope.newUser="";
        }
    };
    
} ]);