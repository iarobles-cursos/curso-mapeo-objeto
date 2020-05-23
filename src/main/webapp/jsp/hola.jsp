<%-- 
    Document   : hola
    Created on : 22/05/2020, 09:09:59 PM
    Author     : iarobles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- usamos una expresion EL -->
        <!-- c:out es para evitar ataques XSS -->
        <h1><c:out value="${msg}"/></h1>
    </body>
</html>
