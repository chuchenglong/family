$(function () {
    var columns = [
        // {checkbox: true},
        {field: 'description', title: '账户描述'},
        {field: 'username', title: '用户名/账户'},
        {field: 'phone', title: '手机号'},
        {field: 'email', title: '邮箱'},
        {field: 'classify', title: '类别'},
        {field: 'purpose', title: '用途'},
        {field: 'operation', title: '操作', width:150,
            formatter: function(value, row, index) {
            return [
                '<input class="btn btn-default btn-xs edit" type="button" value="编辑">',
                '<input class="btn btn-default btn-xs delete" type="button" value="删除">',
                '<input class="btn btn-default btn-xs detail" type="button" value="详情">'
            ];
        }, events: {
            'click .edit': function(e, value, row, index) {
                console.log(row);
                alert("4321");
            },
            'click .delete': function(e, value, row, index) {
                alert("1234");
            },
            'click .detail': function(e, value, row, index) {
                alert("5678");
            }
        }}
    ];

    // 初始化table
    $mc_t.init_page_table("tb_departments", columns, "/account/listPage");

    // 初始化生活账户类别条件选择下拉框
    $mc_s.init_select_ajax("classify", "/publish/data", {"code":"daily_account_classify"}, "生活账户类别");

});

function query() {
    alert("query");
}



