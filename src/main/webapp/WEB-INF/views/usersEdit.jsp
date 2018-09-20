<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Operacja Edytowania grupy</h1>

<form action="/managerUsers" method="get">
    <p> Nazwa użytkownika: <input type="text" name="name"></p>
    <p> email: <input type="text" name="email"></p>
    <p> id grupy: <input type="number" name="group_id"></p>
    <input type="hidden" name="id" value="${users.id}">
    <input type="submit" value="Submit">
</form>
</body>
</html>
