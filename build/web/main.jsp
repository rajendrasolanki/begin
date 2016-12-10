<%-- 
    Document   : index
    Created on : Nov 28, 2016, 11:24:59 AM
    Author     : Rajendra_Solanki
--%>

<!DOCTYPE html>
<html ng-app="MyApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css" type="text/css"/>
        <script src="js/angular.min.js"></script>
        <script src="js/angular-route.js"></script>
    </head>
    <body>
        <div class="MainBox">
            <ul>
                <li style="background-color: darkorchid;"><a href="#"> Home </a></li>
                <li ng-if="Login" style="background-color: violet;"><a href="#addP"> Add Person </a></li>
                <li ng-if="Login" style="background-color: steelblue;"><a href="#check"> Search Person </a></li>
                <li style="background-color: mediumspringgreen;"><a href="#login"> Login </a></li>
                <li style="background-color: burlywood;"><a href="#signup"> Sign-Up </a></li>
            </ul>
            <div ng-view>
                
            </div>
        </div>
        <script src="js/main.js"></script>
    </body>
    
</html>
