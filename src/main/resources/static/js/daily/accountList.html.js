var columns = [
    // {checkbox: true},
    {field: 'id', title: 'id', visible: false},
    {field: 'companyName', title: '所属公司', width: 100, align: 'center', valign: 'middle'},
    {field: 'productName', title: '公司产品', width: 100, align: 'center', valign: 'middle'},
    {field: 'username', title: '用户号', sortable: true, align: 'center', valign: 'middle'},
    {field: 'phone', title: '手机号', sortable: true, align: 'center', valign: 'middle'},
    {field: 'email', title: '邮箱', sortable: true, align: 'center', valign: 'middle'},
    {field: 'classifyName', title: '类别', align: 'center', valign: 'middle'},
    {field:'operation', title: '操作', width: 160, align: 'center', valign: 'middle', formatter: operationFormatter}
];

/**
 * @Discription 初始化页面
 * @author ChenglongChu
 * @create 2018/1/30 15:46
 * */
$(function () {
    // 初始化table
    $mc_t.init_page_table("tb_account", columns, "/account/listPage");
    // 初始化所属公司条件选择下拉框
    $mc_s.init_select_ajax("company", "/publish/data", {"code":"daily_account_company"}, "请输入所属公司");
    // 初始化生活账户类别条件选择下拉框
    $mc_s.init_select_ajax("classify", "/publish/data", {"code":"daily_account_classify"}, "生活账户类别");
});

/**
 * @Discription 根据所选条件查询
 * @author ChenglongChu
 * @create 2018/1/30 15:46
 * */
function query() {
    var params = {};
    params.username = $("#username").val();
    params.companyList = $("#company").val();
    params.classifyList = $("#classify").val();
}

/**
 * @Discription 列表操作按钮
 * @author ChenglongChu
 * @create 2018/1/30 17:35
 * */
function operationFormatter(value, row, index) {
    var result = "";
    result += "<a href='javascript:;' class='btn_min' onclick=\"detailAccount('" + row.id + "')\"><span class='glyphicon glyphicon-search'>详情</span></a>";
    result += "<a href='javascript:;' class='btn_min' onclick=\"updateAccount('" + row.id + "')\"><span class='glyphicon glyphicon-pencil'>编辑</span></a>";
    result += "<a href='javascript:;' class='btn_min' onclick=\"deleteAccount('" + row.id + "')\"><span class='glyphicon glyphicon-remove'>删除</span></a>";
    return result;
}

function detailAccount(id) {
    alert("detail" + id);
}

function updateAccount(id) {
    alert("update" + id);
}

function deleteAccount(id) {
    alert("delete" + id);
}



