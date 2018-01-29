/**
 * @Discription 初始化页面
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
$(function() {
    // 绑定Enter键给登录按钮
    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $('#submit').click();
        }
    });
});

/**
 * @Discription 登录提交
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
function submit() {
    var params = {};
    params.username = $("#username").val();
    params.password = $("#password").val();
    $mc_x.ajax_post_none("/login/check", params, function(result){
        if (result.code == MC_RESULT_SUCCESS) {
            console.log(result.data);
            $mc_w.url("core.html", {"userId":result.data});
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result){Ewin.alert({ message: result.message });});
}

