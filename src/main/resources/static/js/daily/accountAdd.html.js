/**
 * @Discription 初始化页面
 * @author ChenglongChu
 * @create 2018/1/26 17:54
 * */
$(function () {
    // 初始化所属公司条件选择下拉框
    $mc_s.init_select_ajax("company", "/publish/data", {"code":"daily_account_company"}, "请输入所属公司");

    // 初始化产品条件选择下拉框
    $mc_s.init_select("product", "请输入产品");
    $("#company").change(function() {
        var key = $("#company").val();
        $mc_x.ajax_post("/publish/data", {"code": key}, function(result) {
            $mc_s.set_select_data("product", result.data.selects);
        }, function(result) {Ewin.alert({ message: result.message });})
    });

    // 加载生活账户类别
    $mc_s.init_select_ajax("classify", "/publish/data", {"code":"daily_account_classify"}, "请输入生活账户类别");

    // 加载关联账户
    $mc_s.init_select_ajax("refAccountId", "/account/listRel");
});

/**
 * @Discription 生活账户添加提交
 * @author ChenglongChu
 * @create 2018/1/26 17:54
 * */
function submit() {
    var params = {};
    params.username = $("#username").val();
    params.phone = $("#phone").val();
    params.email = $("#email").val();
    params.company = $("#company").val();
    params.product = $("#product").val();
    params.classify = $("#classify").val();
    params.alias = $("#alias").val();
    params.description = $("#description").val();
    params.refAccountId = $("#refAccountId").val();
    params.loginPassword = $("#loginPassword").val();
    params.queryPassword = $("#queryPassword").val();
    params.dealPassword = $("#dealPassword").val();
    $mc_x.ajax_post("/account/insert", params, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            Ewin.alert("添加生活账户成功 !");
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});

}

/**
 * @Discription 重置生活账户输入信息
 * @author ChenglongChu
 * @create 2018/1/30 15:49
 * */
function reset() {
    $mc_s.set_select_data("refAccountId", [{"key":"0","value":"aaaaa"},{"key":"1","value":"bbbb"}]);
}