<%-- 
    Document   : allPosition
    Created on : 13.06.2020, 21:54:54
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Все автомобили</title>
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
                <td> name </td>
                <td> driving </td>
                <td> car </td>
                <td></td>

            </tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                   <td>${car.name}</td>
                   <td>${car.driving}</td>
                   <td>${car.placeOfCar}</td>
                   <td><form action=<c:url value="editCar.jsp"/>
                       <input type="hidden" name="prmNameUp" value="${user}">
                       <input class="btn" type="submit" value="Edit">                     
                   </form>
                   </td>
                   <td><form action="" method="POST"/>
                       <input type="hidden" name="prmNameUp" value="${car}">
                       <input class="btn btn-success" type="submit" value="delete">                     
                   </form>
                   </td>
               </tr>   
           </c:forEach>
        </table>
    </body>
</html>