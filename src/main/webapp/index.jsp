<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>

</head>
<body>
<div id="submitForm">
<el-form>
    <el-form-item label="user">
        <el-input v-model="form.userName" id="userName" type="text">
        </el-input>
        <p>{{from.userErroe}}</p>
    </el-form-item>
    <el-form-item label="passWord">
        <el-input v-model="form.passWord" id="passWord" type="password">
        </el-input>
        <p>{{from.passError}}</p>
    </el-form-item>
    <el-button type="submit" v-click="submitForm()" v-bind:disabled="from.flag">
         提交
    </el-button>
    <el-button type="button" v-click="submitForm()" v-click="fromReset">
        重置
    </el-button>

</el-form>
</div>

</body>
<script>
var first=new Vue({
    el:"#submitForm",
    data:function () {

    }
})
</script>
<script src="https://unpkg.com/vue"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
</html>