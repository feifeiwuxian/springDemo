<%--
  Created by IntelliJ IDEA.
  User: wangfei
  Date: 2020-08-13
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>

    <button class="btn">点击发送</button>

    <script>
        var btn = document.querySelector(".btn")
        btn.addEventListener("click", click)

        function click() {
            var userList = new Array();
            userList.push({username: "zhangsan", age: 24})
            userList.push({username: "lisi", age: 28})
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/save15",
                data: JSON.stringify(userList),
                contentType: "application/json;charset=utf-8"
            })
        }

    </script>



</body>
</html>
