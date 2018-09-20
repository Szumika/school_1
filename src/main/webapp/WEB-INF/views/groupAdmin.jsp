<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<form action='/groupAdmin' method='POST'>

    <input type='submit' value='dodaj' name="admin">
<div>
    <table border="1">
        <c:forEach var="grp" items="${groups}">
            <tr>
                <td>${grp.name}</td>
                <td>  <a href="<c:url value="/groupAdmin?user_group_id=${grp.id}" />">Edytuj</a> <br> </td>
            </tr>
        </c:forEach>
    </table>
</div>

</form>
</body>
</html>
