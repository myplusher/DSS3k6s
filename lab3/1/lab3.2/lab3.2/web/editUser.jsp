<%-- 
    Document   : editUser
    Created on : 13.06.2020, 21:55:50
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактировать юзера</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<style>
            div {
                    width: 50%;
                    margin: auto;
            }
	</style>
    </head>
    <body>
    <table class="table">
    <tr>
        <td>Название</td>
        <td></td>

    </tr>
    <c:forEach items="${users}" var="user">
                 <tr>
                    <td>${user.name}</td>
                    <td>${user.driving}</td>
                    <td>${user.car}</td>
                    <form action=<c:url value="edit.jsp"/>
                        <input type="hidden" name="prmNameUp" value="${user.name}">
                        <input class="btn btn-success" type="submit" value="edit">                     
                    </form>
                </td>
                </tr>   
        </c:forEach>
        </table>

    </body>
</html>