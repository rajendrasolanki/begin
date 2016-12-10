<%-- 
    Document   : Image
    Created on : Dec 8, 2016, 3:41:00 PM
    Author     : Rajendra_Solanki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/angular-route.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form>
            <input type="file" ngf-select="" ng-model="pic" ngf-accept="'image/*'" />
            
        </form>
    </body>
</html>
