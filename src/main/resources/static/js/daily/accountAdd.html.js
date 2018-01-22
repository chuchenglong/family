$(function () {
    $mc_x.ajax_post("/account/list", null, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            $('#refAccountId').selectpicker({
                noneSelectedText : '请选择关联账户'
            });
            $('#refAccountId').append("<option value='1'>"+"ffff"+"</option>");
            $('#refAccountId').append("<option value='2'>"+"aaaaa"+"</option>");
            $('#refAccountId').append("<option value='3'>"+"bbbbb"+"</option>");
            $('#refAccountId').selectpicker('refresh');
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});


});


function submit() {
    var params = {};
    params.accountNo = $("#accountNo").val();
    params.accountName = $("#accountName").val();
    params.refAccountId = $("#refAccountId").val();
    params.phone = $("#phone").val();
    params.email = $("#email").val();
    params.purpose = $("#purpose").val();
    params.description = $("#description").val();
    $mc_x.ajax_post("/account/insert", params, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            Ewin.alert("add success !");
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});

}

function reset() {
    alert("reset account!");
}