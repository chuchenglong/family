$(function () {

    var columns = [
        //{checkbox: true},
        {field: 'accountNo', title: '账户'},
        {field: 'accountName', title: '户名'},
        {field: 'phone', title: '手机号'},
        {field: 'email', title: '邮箱'},
        {field: 'purpose', title: '用途'},
        {field: 'description', title: '描述'},
        {field: 'operation', title: '操作', width:120,
            formatter: function(value, row, index) {
            return [
                '<input class="btn btn-default btn-xs edit" type="button" value="编辑">',
                '<input class="btn btn-default btn-xs delete" type="button" value="删除">'
            ];
        }, events: {
            'click .edit': function(e, value, row, index) {
                console.log(row);
                alert(row.aaa);
            },
            'click .delete': function(e, value, row, index) {
                alert("1234");
            }
        }}
    ];

    var pageSize = 5;
    var pageList = [5,10,'All'];
    //1.初始化Table
    $mc_t.init_page_table("tb_departments", columns, "/account/listPage");

});




