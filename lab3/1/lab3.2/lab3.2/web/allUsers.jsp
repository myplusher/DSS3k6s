<%-- 
    Document   : allUsers
    Created on : 13.06.2020, 21:51:38
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Все юзеры</title>
    </head>
    <body>
    <table class="table">
    <tr>
        <td> name </td>
        <td> driving </td>
        <td> car </td>
        <td></td>

    </tr>
    <c:forEach items="${users}" var="user">
                 <tr>
                    <td>${user.name}</td>
                    <td>${user.driving}</td>
                    <td>${user.placeOfCar}</td>
                    <td><form action=<c:url value="editUser.jsp"/>
                        <input type="hidden" name="prmNameUp" value="${user}">
                        <input class="btn" type="submit" value="Edit">                     
                    </form>
                    </td>
                    <td><form action="" method="POST"/>
                        <input type="hidden" name="prmNameUp" value="${user}">
                        <input class="btn btn-success" type="submit" value="delete">                     
                    </form>
                    </td>
                </tr>   
        </c:forEach>
        </table>
    </body>
</html>