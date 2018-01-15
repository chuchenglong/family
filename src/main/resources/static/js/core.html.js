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
    $("#content").attr('src','account/accountList.html');
}
function turnAccountAdd() {
    $("#content").attr('src','account/accountAdd.html');
}