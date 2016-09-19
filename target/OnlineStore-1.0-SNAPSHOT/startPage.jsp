<%-- 
    Document   : startPage
    Created on : 16 вер. 2016, 11:50:37
    Author     : Marko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="registerForm" method="get" >
        <button type="submit" >registration</button>
    </form>
         <form action="loginForm" method="get" >
        <button type="submit" >login</button>
    </form>
  
        <form action="products/all" method="get" >
        <button type="submit" >store</button>
    </form>
    </body>
</html>
