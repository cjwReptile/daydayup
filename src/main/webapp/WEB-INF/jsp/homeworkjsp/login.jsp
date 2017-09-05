<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<form action="{request.contextPath}/HomeWorkManager/controller/login" method="post">
    用户名：<input type="text" name="userBean.username"><br/>
    密码：<input type="password" name="userBean.password"><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>