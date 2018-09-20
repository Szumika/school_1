<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Operacja dodawania użytkownika</h1>
<form action="/managerAddUsers" method="get">
     Nazwa użytkownika: <input type="text" name="name">
     email: <input type="text" name="email">
     password: <input type="text" name="password">
     id grupy: <input type="number" name="group_id">
    <input type="submit" value="Submit">
</form>
</body>
</html>
