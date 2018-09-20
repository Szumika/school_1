<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<form action='/userAdmin' method='POST'>

    <input type='submit' value='dodaj' name="admin">
<div>
    <table border="1">
        <c:forEach var="user" items="${users}">
            <tr>
                <td> ${user.id}</td> <td>${user.username}</td> <td>${user.email}</td>
                <td><a href="<c:url value="/userAdmin?user_id=${user.id}" />">Edytuj</a><br></td>
            </tr>
        </c:forEach>
    </table>

</div>

</form>
</body>
</html>
