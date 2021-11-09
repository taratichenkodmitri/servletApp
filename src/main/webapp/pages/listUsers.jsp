<%@ page import="java.util.List" %>
<%@ page import="com.hornhub.hornsite.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<User> Users = (List<User>) request.getAttribute("Users");
        for (User s : Users) {
            out.println("<li>" + s.getUsername() + "</li>");
        }
    %>
<br/>
<a href="${pageContext.request.contextPath}">back</a>
</body>
</html>
