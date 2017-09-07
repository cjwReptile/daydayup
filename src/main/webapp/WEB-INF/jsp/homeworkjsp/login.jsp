<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<form action="${pageContext.request.contextPath}/homework/login" method="post">
    用户名：<input type="text" name="userName"><br/>
    密码：<input type="password" name="password"><br/>

    <input type="submit" value="登录">
    ${failMsg}
</form>

</body>
</html>