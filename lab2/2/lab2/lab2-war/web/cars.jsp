<%-- 
    Document   : cars
    Created on : 12.06.2020, 22:00:18
    Author     : Dmi3ev
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cars</title>
    </head>
    <body>
        <h1>Список автомобилей</h1>
        <a href="add-news">Создать</a>
        <table>
            <tr>
                <th>id</th>
                <th>Марка</th>
                <th>Номер</th>
                <th>Пробег</th>
                <th></th>
            </tr>
            <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.number}</td>
                <td>${car.distance}</td>
                <td><a href="edit-news">Изменить</a></td>
                <td>
                    <form action="delete-news" method="post">
                        <input type="hidden" name="id" value="${car.id}">
                        <input type="submit" value="удалить">
                    </form></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
