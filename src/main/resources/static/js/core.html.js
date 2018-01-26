/**
 * @Discription 初始化页面
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
$(function() {
    var params = {};
    params.userId = $mc_w.getUrlParam("userId");
    $mc_x.ajax_post("/login/main", params, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            $("#infoArea").text(result.data.username + "/" + result.data.brief);
            $("#peoplePhoto").attr("src", result.data.photo);

            $("#userId").val(params.userId);
            $("#username").val(result.data.username);
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});

});

/**
 * @Discription 生活账户列表页面跳转
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
function turnAccountList() {
    $("#content").attr('src','daily/accountList.html');
}

/**
 * @Discription 生活账户添加页面跳转
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
function turnAccountAdd() {
    $("#content").attr('src','daily/accountAdd.html');
}

/**
 * @Discription 生活账单列表页面跳转
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
function turnBillList() {
    $("#content").attr('src','daily/billList.html');
}

/**
 * @Discription 生活账单添加页面跳转
 * @author ChenglongChu
 * @create 2017/12/21 16:05
 * */
function turnBillAdd() {
    $("#content").attr('src','daily/billAdd.html');
}