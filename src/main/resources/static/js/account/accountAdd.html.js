$(function () {
    var columns = [
        //{checkbox: true},
        {field: 'userId', title: '用户ID'},
        {field: 'accountNo', title: '账户'},
        {field: 'accountName', title: '账户名称'}
    ];
    var data = [
        {"userId":10002, "accountNo":"A10002", "accountName":"chuxiaoran"},
        {"userId":10001, "accountNo":"A10001", "accountName":"chuchenglong"},
        {"userId":10003, "accountNo":"A10003", "accountName":"zhangjie"}
    ];
    //1.初始化Table
    $mc_t.init_table("tb_test", columns);
    $mc_t.setTableData("tb_test", data);

});