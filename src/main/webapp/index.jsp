<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <a href="${pageContext.request.contextPath}/sign-up">sign up</a>
    <a href="${pageContext.request.contextPath}/list-users">list users</a>
</body>
</html>