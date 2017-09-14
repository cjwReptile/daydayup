
<html>
<head>
    <script src="https://unpkg.com/vue"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

    <script src="./statics/js/jquery.min.js"></script>
    <style>
        html,body{
            margin: 0;
            padding: 0;
            position: relative;
        }
        .row-bg-top{
            background:#B2DBA1;
            text-align: center;
        }
        .row-bg-top span{
            color: #D58512;
            font-family: arial;
            font-size: large;
            vertical-align: middle;
        }
        .dialog{
            height: 100%;,
        width: 100%;
        }
        .login-page{
            position: absolute;
            width: 300px;
            height: 250px;
            top: 50%;
            left: 50%;
            margin-left: -150px;
            margin-top: -125px;
            background-color:#F5F5F5;
            border-radius: 10px;
            box-shadow:0 0 3px #000;
        }
        .grid-content {
            border-radius: 3px;
            min-height: 36px;
            padding: 0px;
        }
    </style>
</head>
<body>

<div id="submit" class="dialog">
    <login :username1="username" :mypassword1="mypassword" class="row-center"></login>
</div>

<template id="login">
    <div class="login-page">
        <el-row>
            <el-col :span="24">
                <div class="grid-content row-bg-top"><span>User login</span></div>
            </el-col>
        </el-row>
        <br>
        <el-row>
            <el-col :span="20" :offset="2">
                <el-input id="username" name="ssss" type="text" v-model="username1"></el-input>
            </el-col>
        </el-row>
        <br>
        <el-row>
            <el-col :span="20" :offset="2">
                <el-input id="password" type="password" v-model="mypassword1"></el-input>
            </el-col>
        </el-row>
        <br>
        <el-row :gutter="40" type="flex"  justify="center">
            <el-col :span="8">
                <el-button  type="primary" @click="login">sign in</el-button>
            </el-col>
            <el-col :span="8">
                <el-button  type="primary">sign up</el-button>
            </el-col>
        </el-row>
    </div>

</template>

</body>
<script>
    new Vue({
        el:"#submit",
        data:{
            username:"",
            mypassword:""
        },
        components:{
            'login':{
                template:"#login",
                props:{
                    username1:"",
                    mypassword1:""
                },
                methods:{
                    login:function(){
                        var name=this.username1;
                        var pass=this.mypassword1;
                        alert(name);
                        alert(pass);
                        $.ajax({
                            url:"../daydayup/homework/login",
                            type:"post",
                            async:true,
                            data:{
                                "userName":name,
                                "password":pass
                            }
                        })

                    }
                }
            }
        }

    })
</script>

</html>