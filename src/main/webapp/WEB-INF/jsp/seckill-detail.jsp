<%--
  Created by IntelliJ IDEA.
  User: cjw
  Date: 2017/6/22
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="common/tag.jsp"%>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>${secKill.name}</h2>
        </div>
        <div class="panel-body text-center">
            <h3 class="text-danger">
                <%-- 显示time图标 --%>
                <span class="glyphicon glyphicon-time"></span>
                <%-- 展示倒计时 --%>
                <span class="glyphicon" id="seckill-box"></span>
            </h3>
        </div>
    </div>

</div>
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="填写手机~" class="form-control">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <%-- 验证信息 --%>
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/statics/seckill-detail.js"></script>

<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%-- 使用CDN获取公共js http://www.bootcdn.cn/ --%>
<%-- jquery countDown倒计时插件--%>
<script src="//cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
<%-- jQuery cookie操作插件 --%>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    $(function () {
        //使用EL表达式传入参数
        seckill.detail.init({
            secKillId:${secKill.secKillId},
            startTime:${secKill.startTime.time}, //转为毫秒
            endTime:${secKill.endTime.time}
        });
    });
</script>
</html>
