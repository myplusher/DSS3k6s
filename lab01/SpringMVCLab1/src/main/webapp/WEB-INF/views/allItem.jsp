<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список товаров</title>
</head>
<body>
<ul>
    <li><a href="allItem">Посмотреть список товаров</a>
    <li><a href="addItem">Добавить новый товар</a>
</ul>
<c:choose>
    <c:when test="${fn:length(list) gt 0}">
        <table border="2" width="70%" cellpadding="2">
            <tr><td>Id</td><td>Имя</td><td>Стоимость</td><td colspan="2">Действия</td></tr>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><a href="edit/${item.id}">Изменить</a></td>
                    <td><a href="delete/${item.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <center><h3>Список пуст, добавте товар</h3></center>
    </c:otherwise></c:choose>
</body>
</html>
