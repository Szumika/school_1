<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Operacja Edytowania grupy</h1>

<form action="/managerGroup" method="get">

    <p> Nazwa Grupy: <input type="text" name="name"></p>
    <input type="hidden" name="id" value="${groups.id}">
    <input type="submit" value="Submit">
</form>
</body>
</html>
