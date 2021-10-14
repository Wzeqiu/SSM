<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wzeqiu
  Date: 2021/10/14
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>查询所有的账户</h2>


<c:forEach items="${list}" var="account">
    ${account.toString()} <br/>
</c:forEach>

</body>
</html>
