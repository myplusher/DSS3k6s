<%-- 
    Document   : addCar
    Created on : 12.06.2020, 22:04:18
    Author     : Роман
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add-news</title>
    </head>
    <body>
        <form action="add-car" method="post">
            <input type="hidden" name="id" value="${car.id}">
            <table>
                <tr> 
                    <td>Марка</td>
                    <td><input required type="text" name="model" value="${car.model}"></td>
                </tr>
                <tr> 
                    <td>Номер</td>
                    <td><input required type="text" name="number" value="${car.number}"></td>
                </tr>
                <tr> 
                    <td>Пробег</td>
                    <td><input required type="text" name="distance" value="${car.distance}"></td>
                </tr>
                <tr> 
                    <td colspan="2"><input type="submit" value="Создать"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
