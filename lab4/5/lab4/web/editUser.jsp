<%-- 
    Document   : editUser
    Created on : 25.06.2020, 17:54:05
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактировать юзера</title>
        <style>
            
        </style>
    </head>
    <body>
            <form action="editUser" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <table>
                <tr> <td>текущее имя - ${user.name}</td>
                    <td><input required type="text" name="name" /></td>
                </tr>
                <tr><td>текущий стаж - ${user.driving}</td>
                <td><input required type="text" name="driving" /></td>
                </tr>
                <tr> <td>текущий автомобиль - ${user.car}</td>
                    <td><input required type="text" name="car" /></td>
                </tr>
                <tr> 
                    <td colspan="2"><input type="submit" value="сохранить"></td>
                </tr></table>
            </form>
    </body>
</html>