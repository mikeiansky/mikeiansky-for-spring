<%--
  Created by IntelliJ IDEA.
  User: winson
  Date: 2021/7/20
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pagecontext.request.contextpath}">
</head>
<body>
    <p>123456</p>

    <p>${pagecontext.request.contextpath}</p>
    <h1>show.jsp</h1>
    <a href="show.do">打开 redirect jsp 页面</a>
    <h3>msg:数据：${msg}</h3>
<%--    <img src="static/images/aa/img2.jpg">--%>
</body>
</html>
