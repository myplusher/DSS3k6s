<%-- 
    Document   : index
    Created on : 29.06.2020, 22:48:06
    Author     : Dmi3ev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="JMS" method="POST">
            Message:
            <textarea name="text"></textarea>
            <button>Send</button>
        </form>
        <form action="JMSServlet" method="GET">
            <button>Get message</button>
        </form><br>
        <c:out value="${msg}"/>
    </body>
</html>
