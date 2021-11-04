<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%= "Hello from signUp.jsp" %>
    <form method="post">
        <label>Name:
            <input type="text" name="name"><br />
        </label>

        <label>Password:
            <input type="password" name="pass"><br />
        </label>
        <button type="submit">Submit</button>
    </form>
    <br/>
    <a href="${pageContext.request.contextPath}">back</a>
</body>
</html>
