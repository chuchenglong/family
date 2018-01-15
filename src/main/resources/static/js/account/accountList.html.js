$(function () {
    var columns = [
        //{checkbox: true},
        {field: 'userId', title: '用户ID'},
        {field: 'accountNo', title: '账户'},
        {field: 'accountName', title: '账户名称'},
        {field: 'phone', title: '手机号'},
        {field: 'creator', title: '创建人'},
        {field: 'updater',title: '修改人'}
    ];

    var columns2 = [
        //{checkbox: true},
        {field: 'aaa', title: 'AAA'},
        {field: 'bbb', title: 'BBB'},
        {field: 'ccc', title: 'CCC'},
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
    $mc_t.init_page_table("tb_departments", columns2, "/account/aaa");

});




