/**  define something about ajax operation */
$mc_x = {};

/**  apply to get request */
$mc_x.ajax_get = function(url, params, successCallback, failCallBack) {
    var reqUrl = url;
    if (params != null) {
        var props = "" ;
        for (var p in params) {
            if ( typeof(params [ p ]) == " function " )
            {
                params [ p ]() ;
            } else {
                props += p + "='" + params [ p ] + "'&" ;
            }
        }
        if(reqUrl.substr(reqUrl.length, 1) == "?") {
            reqUrl +=  props.substr(0, props.length-1);
        } else {
            reqUrl += "?" + props.substr(0, props.length-1);
        }
    }
    $.ajax({
        type: "GET",
        url: reqUrl,
        success: function(result) {
            return successCallback(result);
        },
        error : function(result) {
            return failCallBack(result);
        }
    });
}

/**  apply to post request */
$mc_x.ajax_post = function(url, params, successCallback, failCallBack) {
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        dataType: "json",
        success: function(result) {
            return successCallback(result);
        },
        error : function(result) {
            return failCallBack(result);
        }

    });
}
