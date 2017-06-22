var seckill={
    URL: {
        now: function(){
            return '/daydayup/seckill/time/now';
        },
        exposer: function(seckillId){
            return '/daydayup/seckill/'+seckillId+'/secKillUrl';
        },
        execution: function (seckillId,md5) {
            return '/daydayup/seckill/'+seckillId+'/'+md5+'/excuteSecKill';
        }
    },
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else return false;
    },

    handleSeckillKill:function (seckillId,seckillBox) {
        seckillBox.hide().html('<button class="btn btn-primary btn-lg" id="killBtn" >开始秒杀</button>');
        $.ajax({
            url:seckill.URL.exposer(seckillId),
            type:"post",
            async:false,
            success:function (result) {
                if(result.data||result.success){
                    seckillBox.show();
                     var exproser=result.data; 
                     if(exproser.exproser){
                         $('#killBtn').one('click', function () {
                             //执行秒杀请求
                             //1.先禁用按钮
                             $(this).addClass('disabled');
                             var md5=exproser.md5;
                             var killUrl=seckill.URL.execution(seckillId,md5);
                             //2.发送秒杀请求执行秒杀
                             console.log(killUrl);
                             $.post(killUrl,{}, function (result) {
                                 if (result && result['success']){
                                     var killResult=result['data'];
                                     var state=killResult['state'];
                                     var stateInfo =killResult['stateInfo'];
                                     console.log(stateInfo);
                                     //显示秒杀结果
                                     seckillBox.html('<span class="label label-success">'+stateInfo+'</span>');
                                 }
                             });
                         });

                     }else{
                         
                     }
                }
            }

        })
    },

    countdown:function (startTime,endTime,nowTime,secKillId) {
         var seckillbox=$("#seckill-box");
         if(nowTime<startTime){
             seckillbox.html("还未开始");
             var time=new Date(startTime+1000);
             seckillbox.countdown(time,function (event) {
                 //时间格式
                 var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒')
                 seckillbox.html(format);
                 /*时间完成后的回调函数*/
             }).on('finish.countdown', function () {
                 //获取秒杀地址，控制显示逻辑，执行秒杀哦
                 seckill.handleSeckillKill(seckillId,seckillbox);
             });

         }else if(nowTime>endTime){
             seckillbox.html("秒杀结束");
         }else{
             seckill.handleSeckillKill(secKillId,seckillbox);
         }
    },
    detail: {
        //详情页初始化
        init: function (params) {
            //手机验证和登录，及时交互
            //规划交互流程
            //在cookie中查找手机号
            var killPhone = $.cookie("killPhone");
            //验证手机号
            if (!seckill.validatePhone(killPhone)) {
                //绑定phone
                //控制输出
                var killPhoneModal = $('#killPhoneModal');
                killPhoneModal.modal({
                    show: true,//显示弹出层
                    backdrop: 'static',//禁止位置关闭
                    keyboard: false//关闭键盘事件
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneKey').val();
                    if (seckill.validatePhone(inputPhone)){
                        //电话写入cookie
                        $.cookie('killPhone',inputPhone,{expires:7,path:'/daydayup/seckill'});
                        //刷新页面
                        window.location.reload();
                    }else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误！</label>').show(300);
                    }
                });
            }
            //用户已经登录
            //计时交互
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['secKillId'];
            $.get(seckill.URL.now(),{}, function (result) {
                if (result && result['success']){
                    var nowTime = result['data'];
                    //时间判断
                    seckill.countdown(startTime,endTime,nowTime,seckillId);
                }else {
                    console.log('result:'+result);
                }
            })
        }
    }
}