<%-- 
    Document   : count-add-car
    Created on : 12.06.2020, 22:07:01
    Author     : Роман
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Количество добавленных автомобилей</title>
    </head>
    <body>
        <label><h2>Количество добавленных автомобилей = ${countAdd}</h2></label>
        </br>
        <label><h2>Title add News = </h2></label>
        <c:forEach items="${modelAdd}" var="model">
            <h2>${model}, </h2>
        </c:forEach>
    </body>
</html>
