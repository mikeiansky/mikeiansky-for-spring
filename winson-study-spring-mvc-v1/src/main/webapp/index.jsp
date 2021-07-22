<%--
  Created by IntelliJ IDEA.
  User: winson
  Date: 2021/7/20
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <p>Hello Winson Jsp</p>
    <a href="some.do">发起some.do的请求</a><br/>
    <form action="param.do" method="post">
        <input type="text" name="name"><br/>
        <input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
