<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 09/23/2023
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginSuccess</title>
</head>
<body>

<h3>Hi <%= request.getAttribute("user")%>,Login success.</h3>
<a href=" login.html ">Login Page</a>

</body>
</html>
