<%-- 
    Document   : login
    Created on : 18 вер. 2016, 14:32:49
    Author     : Marko
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
      ${requestScope.message}
         <form:form action="login" method="post" commandName="user">
                
                     Login: 
                      <br>
                   <form:input path="login" size="30"/>
                    <form:errors path="login" cssClass="error"/>
            <br>
             
                    Password:
                     <br>
                    <td><form:password path="password" size="30"/>
                    <td><form:errors path="password" cssClass="error"/>
            <br>
              <input type="submit" value="login"/>
                    </form:form>
    </body>
</html>
