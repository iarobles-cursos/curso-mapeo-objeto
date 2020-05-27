<%-- 
    Document   : inicio
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
        <h1><c:out value="${mensaje}" /></h1>
        <c:forEach var="articulo" items="${articulos}">
            <div>
                <h2><c:out value="${articulo.titulo}"/></h2>
                <p><c:out value="${articulo.contenido}"/></p>
            </div>
        </c:forEach>
    </body>
</html>
