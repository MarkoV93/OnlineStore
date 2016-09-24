<%-- 
    Document   : newjsp
    Created on : 19 вер. 2016, 17:00:59
    Author     : Marko
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
          <c:choose>
            <c:when test="${sessionScope.user==null }">
                <button onclick="window.location.href = 'http://localhost:8084/OnlineStore/loginn'">Log in</button>
               
                <br />
            </c:when>    
            <c:otherwise>
                <button onclick="window.location.href = 'http://localhost:8084/OnlineStore/logout'">Log out</button>
                 <button onclick="window.location.href = 'http://localhost:8084/OnlineStore/user/${sessionScope.user.login}'">User Pro File</button>
                <br />
            </c:otherwise>
        </c:choose>
        ${product.category.name}    ${product.city.name}
        <h1>${product.name}</h1>
        ${product.name}    ${product.price}  
        ${product.image}
        ${product.description}
       
<button onclick="window.location.href='http://localhost:8084/OnlineStore/products/all'">Products</button>
 <button onclick="window.location.href='http://localhost:8084/OnlineStore/products/${product.category.name}'">${product.category.name}</button>
    </body>
</html>
