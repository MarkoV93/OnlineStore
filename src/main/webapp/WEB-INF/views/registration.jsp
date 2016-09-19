<%-- 
    Document   : registration
    Created on : 18 вер. 2016, 12:08:49
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
        <h1>Hello World!</h1>
          <form:form action="registration" method="post" commandName="user">
                
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
            @mail:
             <br>
                    <form:input path="email" size="30"/>
                   <form:errors path="email" cssClass="error"/>
                         <br>
                       name:
                        <br>
                   <form:input path="name" size="30"/>
                    <form:errors path="name" cssClass="error"/>
                         <br>
                          phone:
                           <br>
                    <form:input path="phone" size="30"/>
                    <form:errors path="phone" cssClass="error"/>
                    <br>
                      surname:
                       <br>
                  <form:input path="surname" size="30"/>
                 <form:errors path="surname" cssClass="error"/>
                    <br>
                  <input type="submit" value="register"/>
               
        </form:form>
    </body>
</html>
