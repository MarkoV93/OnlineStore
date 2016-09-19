<%-- 
    Document   : store
    Created on : 19 вер. 2016, 10:31:59
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
        <h1>Store</h1>
        
                       
        <c:forEach var="category" items="${sessionScope.categories}">
                            <form action="${category.name}">
                            <button type="submit" >${category.name}</button>
                            </form>
                        </c:forEach>
       
                           
                       
                                
                           <table border="2" class="table table-hover">
                        <tr > <b>
                            <td> name </td> 
                            <td> price</td> 
                            <td> description </td> 
                            <td>   image</td>

                        </b>
                        </tr>
                        <c:forEach var="product" items="${requestScope.products}">
                            <tr>
                                <td>     ${product.name} </td> 
                                <td>     ${product.price}</td> 
                                <td>     ${product.description} </td> 
                                <td>     ${product.image} </td>
                            <form action="showProduct/${product.id}" method="get">
                                <td><button >show</button></p></td>
                            </form>
                            </tr>
                        </c:forEach>
                          
                      
    
    </body>
</html>
