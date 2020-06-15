<%-- 
    Document   : createPosition
    Created on : 13.06.2020, 21:55:38
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить автомобиль</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<style>
            div {
                    width: 50%;
                    margin: auto;
            }
	</style>
    </head>
    <body>
        <form action="" method="POST"
              <table class="table">
                  <tr>
                      <td>
                          Имя
                      </td>
                      <td><input required type="text" name="name"/></td>
                   </tr>
                   <tr>
                      <td>
                          Возраст
                      </td>
                      <td><input required type="text" name="age"/></td>
                    </tr>
                    <tr>
                      <td>
                          Должность
                      </td>
                      <td><input required type="text" name="position"/></td>
                  </tr>
            </table>
    </form>
    </body>
</html>