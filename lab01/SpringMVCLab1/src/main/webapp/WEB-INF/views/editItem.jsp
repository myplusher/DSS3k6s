<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 07.05.2020
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить товар</title>
</head>
<body>
<form:form method="post" action="apply">
    <table>
        <form:hidden path="id"/>
        <tr><td>Имя</td>
            <td><form:input  path="name"/></td>
        </tr>
        <tr>
            <td>Стоимость</td>
            <td><form:input path="price"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Принять изменения" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>
