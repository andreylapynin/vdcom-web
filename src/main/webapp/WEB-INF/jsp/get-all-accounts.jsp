<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="account" items="${accountAll}">
    <tr>
        <td>
            <li>
                    ${account.name}, ${account.password}
                <a href="${pageContext.request.contextPath}/account/update?id=${account.id}"/>Update </a>
                <a href="${pageContext.request.contextPath}/account/delete?id=${account.id}"/> Delete </a>
            </li>
        </td>
    </tr>
</c:forEach>
<a href="${pageContext.request.contextPath}/account/create"/>Create </a>
<br>
<form action="/account/upload" method="post" enctype="multipart/form-data">
    <br>
    <br><input type="file" required style=position:absolute;left:7% name="file">
    <input type="submit" value="upload"/>
</form>
<br>
</body>
</html>