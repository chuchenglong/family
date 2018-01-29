$mc_s = {};

$mc_s.init_select = function(selectId, text) {
    if (undefined == text || null == text) {
        text = "--请选择--";
    }
    $('#' + selectId).selectpicker({noneSelectedText : text});
    $('#' + selectId).selectpicker('refresh');
}

$mc_s.init_select_data = function(selectId, datas, text) {
    if (undefined == datas || null == datas) {
        $('#' + selectId).selectpicker({noneSelectedText : "--无数据--"});
        $("#" + selectId).prop('disabled', true);
    } else {
        if (undefined == text || null == text) {
            text = "--请选择--";
        }
        $('#' + selectId).selectpicker({
            noneSelectedText : text
        });
        $.each(datas, function (i) {
            $('#' + selectId).append("<option value=" + datas[i].key +">"+ datas[i].value +"</option>");
        });
    }
    $('#' + selectId).selectpicker('refresh');
}

$mc_s.init_select_ajax = function(selectId, url, params, text) {
    var index = 0;
    $mc_x.ajax_post(url, params, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            var datas = result.data.selects;

            if (undefined == datas || null == datas) {
                index = index + 1;
            }
            $.each(datas, function (i) {
                index = index + 1;
            });
            if (index == 0) {
                $('#' + selectId).selectpicker({noneSelectedText : "--无数据--"});
                $('#' + selectId).prop('disabled', true);
            } else {
                if (undefined == text || null == text) {
                    text = "--请选择--";
                }
                $('#' + selectId).selectpicker({noneSelectedText : text});
                $.each(datas, function (i) {
                    $('#' + selectId).append("<option value=" + datas[i].key +">"+ datas[i].value +"</option>");
                });
            }
            $('#' + selectId).selectpicker('refresh');
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});
}

$mc_s.init_select_ajax_none = function(selectId, url, params, text) {
    var index = 0;
    $mc_x.ajax_post_none(url, params, function(result) {
        if (result.code == MC_RESULT_SUCCESS) {
            var datas = result.data.selects;

            if (undefined == datas || null == datas) {
                index = index + 1;
            }
            $.each(datas, function (i) {
                index = index + 1;
            });
            if (index == 0) {
                $('#' + selectId).selectpicker({noneSelectedText : "--无数据--"});
                $('#' + selectId).prop('disabled', true);
            } else {
                if (undefined == text || null == text) {
                    text = "--请选择--";
                }
                $('#' + selectId).selectpicker({noneSelectedText : text});
                $.each(datas, function (i) {
                    $('#' + selectId).append("<option value=" + datas[i].key +">"+ datas[i].value +"</option>");
                });
            }
            $('#' + selectId).selectpicker('refresh');
        } else {
            Ewin.alert({ message: result.message });
        }
    }, function(result) {Ewin.alert({ message: result.message });});
}

$mc_s.set_select_data = function(selectId, datas) {
    document.getElementById(selectId).options.length = 0;
    if (undefined == datas || null == datas) {
        $('#' + selectId).selectpicker('refresh');
        return;
    }
    $.each(datas, function (i) {
        $('#' + selectId).append("<option value=" + datas[i].key +">"+ datas[i].value +"</option>");
    });
    $('#' + selectId).selectpicker('refresh');
}