/**
 * @Discription 初始化页面
 * @author ChenglongChu
 * @create 2018/2/1 9:43
 * */
$(function () {
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
});