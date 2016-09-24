<%-- 
    Document   : userPage
    Created on : 18 вер. 2016, 15:39:05
    Author     : Marko
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
         <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
         <script src="<c:url value="/resource/js/userPage.js" />"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${sessionScope.user.login}
        ${sessionScope.user.name}
        ${sessionScope.user.surname}
        ${sessionScope.user.email}
        ${sessionScope.user.phone}
        <h3>change Password:</h3>
        <input id="oldPassword" type="text">
        <input id="newPassword" type="text">
        <input type="button" value="OK" onclick="changePassword()">
        <p id="result_text"></p>
 
    </body>
</html>
