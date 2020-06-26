<%-- 
    Document   : addUser
    Created on : 25.06.2020, 17:52:23
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Создание нового пользователя</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
    <form action="addUser" method="post">
            <table>
            <tr>
                <td>имя</td>
                <td><input required type="text" name="name" /></td>
            </tr>
            <tr>
                <td>стаж вождения</td>
                <td><input required type="text" name="driving"  /></td>
            </tr>
            <tr>
                <td>автомобиль</td>
                <td><input required type="text" name="car"  /></td>
            </tr>
                
            <tr>
                <td>
                    <input required type="submit" value="Сохранить"/>
                </td></tr>
            </table>   
    </form>
        <h3 class="error">${error}</h3>
    </body>
</html>