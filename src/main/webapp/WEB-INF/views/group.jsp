
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Programming School</title>
</head>
<body>

<%@ include file="/WEB-INF/views/fragments/header.jspf" %>
<div>
    <table border="1">

    <c:forEach var="grp" items="${groups}">
        <tr>
        <td>${grp.name}</td> <td><a href='/userlist?user_group_id=${grp.id}'>Szczegoly</a><br></td>
        </tr>
    </c:forEach>


    </table>


</div>


</body>
</html>
