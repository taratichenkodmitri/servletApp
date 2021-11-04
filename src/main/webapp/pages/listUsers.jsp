<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<String> names = (List<String>) request.getAttribute("userNames");
        for (String s : names) {
        out.println("<li>" + s + "</li>");
        }
    %>
<br/>
<a href="${pageContext.request.contextPath}">back</a>
</body>
</html>
