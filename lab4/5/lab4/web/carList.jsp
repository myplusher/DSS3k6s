<%-- 
    Document   : carList
    Created on : 25.06.2020, 17:54:36
    Author     : Dmi3ev
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список автомобилей</title>
        
        <style>
            table{
                border-spacing:0;
                width: 80%;
                height: 100%;
                font-size: 20px;
            }
            
            .btn{
                background: none;
                color: black;
                border: 0;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        
        <table align="center">
    <tr>
        <td>модель</td>
        <td>номер</td>
        <td>дистанция</td>
        <td></td>
    </tr>
    <c:forEach items="${carList}" var="car">
                 <tr>
                    <td>${car.model}</td>
                    <td>${car.number}</td>
                    <td>${car.distance}</td>
                <td><form action="carList" method="post">
                    <input type="hidden" name="id" value="${car.id}">
                    <input class="btn" type="submit" value="удалить">
                </form>
                </td>
                </tr>
        </c:forEach>
        </table>
    </body>
</html>