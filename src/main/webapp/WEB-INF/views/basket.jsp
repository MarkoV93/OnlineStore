<%-- 
    Document   : basket
    Created on : 22 вер. 2016, 18:14:00
    Author     : Marko
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
         <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Basket</title>
    </head>
    <body>
 
        <c:choose>
        <c:when test="${sessionScope.login==null or sessionScope.login==' '}">
        <button onclick="window.location.href='http://localhost:8084/OnlineStore/loginn'">Log in</button>
        <br />
    </c:when>    
    <c:otherwise>
        <button onclick="window.location.href='http://localhost:8084/OnlineStore/logout'">Log out</button>
        <br />
    </c:otherwise>
        </c:choose>
        ${sessionScope.login}
        <h1>Basket</h1>
        <button onclick="window.location.href='http://localhost:8084/OnlineStore/products/all'">Products</button>       <p id="result_text"></p> 
            <table border="2" class="table table-hover">
                        <tr > <b>
                            <td> id </td> 
                            <td> name </td> 
                            <td> price</td> 
                            <td> description </td> 
                            <td>   image</td>
                              <td>   show</td>
                        </b>
                        </tr>
                        <c:forEach var="product" items="${sessionScope.basket}">
                            <tr><td>     ${product.id} </td> 
                                <td>     ${product.name} </td> 
                                <td>     ${product.price}</td> 
                                <td>     ${product.description} </td> 
                                <td>     ${product.image} </td>
                                <td><button onclick="window.location.href='http://localhost:8084/OnlineStore/products/showProduct/${product.id}'">show</button</td>
                            <td> <input type="button" class="productClass"  value="${product.id}" ></td>
                            </tr>
                                   </c:forEach>   
                            <form action="buy" method="Post">
                            <button type="submit" >buy</button>
                            </form>
                              <script type="text/javascript">
var products = document.getElementsByClassName('productClass');

for (var i = 0; i < products.length; i++) {
console.log(products[i]);
products[i].onclick = doAjax;
}
            function doAjax(event) {
                console.log(arguments);
                var inputText = event.target.value;
                console.log(inputText);
                $.ajax({
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8;',
                    url: 'deleteFromBasket',
                    type: 'Delete',
                    dataType: 'json',
                    contentType: 'application/json',
                            mimeType: 'application/json',
                    data: ({
                      inputText
                    }),
   
                success: function () {
                        console.log('in success');
                        var result = 'deleted';
                        $("#result_text").text(result);
                    }
                    
                });
            }
        </script>
    </body>
</html>
