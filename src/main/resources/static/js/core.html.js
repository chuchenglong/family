$(function() {
    var params = {};
    params.userId = $mc_w.getUrlParam("userId");
    $mc_x.ajax_post("/login/queryUserByUserId", params, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            console.log(result.data);
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});

});

function turnAccountList() {
    $("#content").attr('src','daily/accountList.html');
}
function turnAccountAdd() {
    $("#content").attr('src','daily/accountAdd.html');
}
function turnBillList() {
    $("#content").attr('src','daily/billList.html');
}
function turnBillAdd() {
    $("#content").attr('src','daily/billAdd.html');
}