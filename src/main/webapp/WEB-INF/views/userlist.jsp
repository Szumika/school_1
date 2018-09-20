
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Programming School</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<div><a href="/group">powrót</a> </div>
<div>
    <table>
        <c:forEach var="user" items="${Users}">
            <tr>
                <td>${user.username}</td> <td><a href='/userdet?user_id=${user.id}'>Szczegoly</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
