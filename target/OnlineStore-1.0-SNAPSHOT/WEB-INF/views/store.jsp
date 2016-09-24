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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

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

        ${sessionScope.login}
        <h1>Store</h1>              <button onclick="window.location.href = 'http://localhost:8084/OnlineStore/showBasket'">Basket</button>
        <p id="result_text"></p> 
        ${requestScope.message}
        <c:forEach var="category" items="${sessionScope.categories}">
            <form action="${category.name}">
                <button type="submit" >${category.name}</button>
            </form>
        </c:forEach>
        <form action="all">
            <button type="submit" >All</button>
        </form>



        <table border="2" class="table table-hover">
            <tr > <b>
                <td> id </td> 
                <td> name </td> 
                <td> price</td> 
                <td> description </td> 
                <td>   image</td>
                <td>add</td>
            </b>
        </tr>
        <c:forEach var="product" items="${requestScope.products}">
            <tr><td>     ${product.id} </td> 
                <td>     ${product.name} </td> 
                <td>     ${product.price}</td> 
                <td>     ${product.description} </td> 
                <td>     ${product.image} </td>
            <form action="showProduct/${product.id}" method="get">
                <td><button >show</button></p></td>
            </form>
            <td> <input type="button" class="productClass"  value="${product.id}" ></td>
        </tr>
    </c:forEach>                          
    <c:forEach var="i" begin="0" end="${requestScope.pages}">
        <form action="${requestScope.path}" method="get">
            <button type="submit" name="page" value="${i}" >${i}</button>

        </form>
    </c:forEach>

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
                url: 'addToBasket',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                        mimeType: 'application/json',
                data: ({
                    inputText
                }),
                success: function (data) {
                    console.log('in success');
                    var result = data.name + ' was added';
                    $("#result_text").text(result);
                }

            });
        }
    </script>
</body>
</html>