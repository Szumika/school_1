<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 17.07.18
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<br>
<h1>Dane urzytkownika: ${Users.username}</h1><br>

<div>
    <ul>
        <li>
            Imie: ${Users.username}<br><br>
        </li>

        <li>
            email: ${Users.email}<br><br>

        </li>
        <c:forEach var="sol" items="${Solution}">
            <li>${sol.description} ${sol.created} <a href='/exercise?exercise_id=${sol.exercise_id}'>Exercise</a> </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
