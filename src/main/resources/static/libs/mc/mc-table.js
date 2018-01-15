$mc_t = {};

/**  apply to simple table */
$mc_t.init_simple_table = function(tableId, columns) {
    $('#' + tableId).bootstrapTable({
        columns: columns,                      // 列表中表头
        cache: false,                              // 是否使用缓存, 默认为true
        striped: true,                            // 是否显示行间隔色
        clickToSelect: true                 // 是否启用点击选中行
    });
}

/**  apply to common table, no pagination */
$mc_t.init_table = function(tableId, columns) {
    $('#' + tableId).bootstrapTable({
        columns: columns,                      // 列表中表头
        toolbar: '#toolbar',                  // 工具按钮用的容器
        cache: false,                              // 是否使用缓存, 默认为true
        striped: true,                            // 是否显示行间隔色
        clickToSelect: true,                 // 是否启用点击选中行
        search: true,                             // 是否显示表格搜索, 此搜索是客户端搜索, 不会进服务端, $1
        strictSearch: false,                 // 搜索是否精准匹配, $1
        cardView: false,                        // 是否以详细视图显示, $2
        showToggle: true,                     // 是否显示详细视图和列表视图的切换按钮, $2
        showColumns: true,                   // 是否显示所有的列, $3
        minimumCountColumns: 2,         // 最少允许的列数, $3
        showRefresh: true,                   // 是否显示刷新按钮
        detailView: false                       // 是否显示父子表
    });
}

/**  set data into table, just support client way */
$mc_t.setTableData = function(tableId, data) {
    $("#" + tableId).bootstrapTable("load", data);
}

/**  apply to simple table, no pagination, set data from url */
$mc_t.init_simple_table_ajax = function(tableId, columns, url, params) {
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        dataType: "json",
        success: function(result) {
            if (result.code == MC_RESULT_SUCCESS) {
                var dataValue = result.data;
                $mc_t.init_simple_table(tableId, columns);
                $mc_t.setTableData(tableId, dataValue);
            } else {
                Ewin.alert({ message: result.message });
            }
        },
        error : function(result) {
            Ewin.alert({ message: result.message });
        }
    });
}

/**  apply to common table, no pagination, set data from url */
$mc_t.init_table_ajax = function(tableId, columns, url, params) {
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        dataType: "json",
        success: function(result) {
            if (result.code == MC_RESULT_SUCCESS) {
                var dataValue = result.data;
                $mc_t.init_table(tableId, columns);
                $mc_t.setTableData(tableId, dataValue);
            } else {
                Ewin.alert({ message: result.message });
            }
        },
        error : function(result) {
            Ewin.alert({ message: result.message });
        }
    });
}

/**  apply to pagination table, pagination from service, just support post request method */
$mc_t.init_page_table = function(tableId, columns, url, params, pageSize, pageList) {
    if (undefined == pageList || null == pageList) {
        pageList = [10, 20];
    }
    if (undefined == pageSize || null == pageSize) {
        pageSize = 10;
    }
    if (undefined == params || null == params) {
        params = {};
    }
    params.pageSize = pageSize;
    params.offset = pageSize * (params.pageNumber-1) + 1;
    params.startPoint = pageSize * (params.pageNumber-1);
    params.endPoint = pageSize * (params.pageNumber);

    $('#' + tableId).bootstrapTable({
        columns: columns,                      // 列表中表头
        toolbar: '#toolbar',                  // 工具按钮用的容器
        cache: false,                              // 是否使用缓存, 默认为true
        striped: true,                            // 是否显示行间隔色
        clickToSelect: true,                 // 是否启用点击选中行
        search: true,                             // 是否显示表格搜索, 此搜索是客户端搜索, 不会进服务端, $1
        strictSearch: false,                 // 搜索是否精准匹配, $1
        cardView: false,                        // 是否以详细视图显示, $2
        showToggle: true,                     // 是否显示详细视图和列表视图的切换按钮, $2
        showColumns: true,                   // 是否显示所有的列, $3
        minimumCountColumns: 2,         // 最少允许的列数, $3
        url: url,                                      // 请求URL, $4
        method: 'post',                         // 请求方式, $4
        contentType: "application/json",       // 请求content type, $4
        // 传递参数, 这里应该返回一个object, 即形如{param1:val1,param2:val2}, $4
        queryParams: params,
        pagination: true,                         // 是否显示分页, $4
        sidePagination: "server",           // 分页方式: client客户端分页, server服务端分页, $4
        pageNumber: 1,                          // 初始化加载第一页, 默认第一页, $4
        pageSize: pageSize,                   // 每页的记录行数, $4
        pageList: pageList,                    // 可供选择的每页的行数, $4
        smartDisplay: false,                  // 智能显示分页按钮, $4
        paginationPreText: "上一页",     // 上一页按钮, $4
        paginationNextText: "下一页",  // 下一页按钮, $4
        onLoadSuccess: function() {
            // 列表加载成功后执行
        },
        onLoadError: function() {
            // 列表加载失败后执行
        },
        showRefresh: true,                    // 是否显示刷新按钮
        detailView: false                        // 是否显示父子表
    });
}

/**  apply to pagination table, pagination from client */
$mc_t.init_page_table_client = function(tableId, columns, datas, pageSize, pageList) {

}

