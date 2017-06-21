/**
 * Created by cjw on 2017/6/20.
 */
function test() {
    var url="../cjw/seckill";
    var userId=$("#userId").val();
    var secKillId=$("#secKillId").val();
    $.ajax({
        url:url,
        type:"post",
        data:{"param[userId]":userId,"param[secKillId]":secKillId},
        async:false,
        success:function(data){
            alert("sssss");
        }
    })
}