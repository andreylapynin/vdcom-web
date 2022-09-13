<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create account</title>
</head>
<body>
<form action="/account/update" method="post">
    <br>name <input type="text" required style=position:absolute;left:7% name="name" value="${account.name}">
    <br>password<input type="text" required style=position:absolute;left:7% name="password" value="${account.password}">
    <input type="hidden" name="id" value="${account.id}">
    <br><input type="submit" value="update"/>
</form>
</body>
</html>