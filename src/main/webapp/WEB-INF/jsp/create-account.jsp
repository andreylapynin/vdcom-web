<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create account</title>
</head>
<body>
<form action="/account/create" method="post">
    <br>name <input type="text" required style=position:absolute;left:7% name="name">
    <br>password<input type="text" required style=position:absolute;left:7% name="password">
    <br><input type="submit" value="create"/>
</form>
</body>
</html>