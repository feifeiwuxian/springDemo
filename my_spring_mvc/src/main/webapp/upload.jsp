<%--
  Created by IntelliJ IDEA.
  User: wangfei
  Date: 2020-08-14
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <div>多文件</div>
    <form action="${pageContext.request.contextPath}/user/save23" method="post" enctype="multipart/form-data">

        文件<input type="file" multiple name="uploadFiles"> <br>
        <input type="submit" value="提交">
    </form>
    <div>单文件</div>

    <form action="${pageContext.request.contextPath}/user/save22" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"> <br>
        文件<input type="file" name="uploadFile"> <br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
