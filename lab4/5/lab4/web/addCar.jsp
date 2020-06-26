<%-- 
    Document   : addCar
    Created on : 25.06.2020, 17:53:45
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить автомобиль</title>

    </head>
    <body>
    <form action="addCar" method="post">
            <table>
            <tr>
                <td>модель</td>
                <td><input required type="text" name="model" /></td>
            </tr>
            <tr>
                <td>номер</td>
                <td><input required type="text" name="number"  /></td>
            </tr>
            <tr>
                <td>Пройденная дистанция</td>
                <td><input required type="text" name="distance"  /></td>
            </tr>
                
            <tr>
                <td>
                    <input required type="submit" value="Сохранить"/>
                </td></tr>
            </table>   
    </form>
    </body>
</html>