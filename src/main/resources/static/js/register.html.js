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
        if (event.keyCode == "46") {
            $('#reset').click();
        }
    });
});

/**
 * @Discription 注册提交
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
function submit() {
    var params = {};
    params.username = $("#username").val();
    params.email = $("#email").val();
    params.phone = $("#phone").val();
    params.alias = $("#alias").val();
    params.gender = $("input[name='gender']:checked").val();
    params.photo = $("#photo").val();
    params.brief = $("#brief").val();
    params.password = $("#password").val();

    // 请求注册用户
    $mc_x.ajax_post_none("/register/insert", params, function(result){
        if (result.code == MC_RESULT_SUCCESS) {
            Ewin.alert({ message: "注册成功 !" }).on(function () {
                $mc_w.url("login.html");
            });
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result){Ewin.alert({ message: result.message });});
}

/**
 * @Discription 重置注册输入内容
 * @author ChenglongChu
 * @create 2017/12/21 16:06
 * */
function reset() {
    // 随便写的, 后面改
    Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
        if (!e) {
            //console.log(e);
            return;
        }
        alert("功能待完成");
    });
}