
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Programming School</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %><br><br>
<div>
    <table border=1>

        <c:forEach var="sol" items="${solution}">
        <tr>
            <td>${sol.description}</td> <td> ${sol.created}</td> <td> <a href='/exercise?exercise_id=${sol.exercise_id}'>Exercise</a> </td>
        </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>
