<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hornhub.hornsite.entities.user" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<user> users = (List<user>) request.getAttribute("users");
        for (user s : users) {
        out.println("<li>" + s.getUsername() + "</li>");
        }
    %>
<br/>
<a href="${pageContext.request.contextPath}">back</a>
</body>
</html>
