<%-- 
    Document   : editPosition
    Created on : 13.06.2020, 21:56:05
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактировать автомобиль</title>
    </head>
    <body>
    <table align="center">
    <tr>
        <td>Название</td>
        <td></td>

    </tr>
    <c:forEach items="${cars}" var="car">
                 <tr>
                    <td>${car.model}</td>
                    <td>${car.number}</td>
                    <td>${car.distance}</td>
                    <form action=<c:url value="editTeam.jsp"/>>
                        <input type="hidden" name="prmNameUp" value="${car.name}">
                        <input class="btn" type="submit" value="edit">                     
                    </form>
                </td>
                </tr>   
        </c:forEach>
        </table>

    </body>
</html>