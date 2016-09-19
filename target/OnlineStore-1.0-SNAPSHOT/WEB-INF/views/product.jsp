<%-- 
    Document   : newjsp
    Created on : 19 вер. 2016, 17:00:59
    Author     : Marko
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        ${product.category.name}    ${product.city.name}
        <h1>${product.name}</h1>
        ${product.name}    ${product.price}  
        ${product.image}
        ${product.description}
        <form action="products/all" method="get">
<button onclick="window.location.href='http://localhost:8084/OnlineStore/'">Products</button>
        </form>
    </body>
</html>
