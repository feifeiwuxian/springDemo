<%--
  Created by IntelliJ IDEA.
  User: wangfei
  Date: 2020/10/19
  Time: 3:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加帐户信息表单</h1>
    <form name="accountFourm" action="${pageContext.request.contextPath}/account/save" method="post">
        帐户名称：<input type="text" name="name"><br>
        帐户金额：<input type="text" name="money"><br>
        <input type="submit" value="保存"><br>
    </form>
</body>
</html>
