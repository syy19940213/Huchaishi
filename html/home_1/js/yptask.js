$(function () {
    //任务筛选
    var w = $("#w").val();
    if (w == "") w = "00000"
    var i;
    var num;
    var a;
    for (i = 0; i < w.length; i++) {
        num = w.substr(i, 1);
        a = $("#b2first tr").eq(i).find("[w='" + num + "']");
        a.attr("class", "acolor");
        if (num != "0")a.parent().parent().find(".buxian2").attr("class", "buxian");
    }

    $("#b2first a[w!=0]").click(function () {
        var tr = $(this).parent().parent();
        tr.find("a").removeClass();
        tr.find(".buxian2").attr("class", "buxian");
        $(this).attr("class", "acolor");
        get_con();
    });
    $("#b2first a[w=0]").click(function () {
        var tr = $(this).parent().parent();
        tr.find("a").removeClass();
        tr.find(".buxian").attr("class", "buxian2");
        $(this).attr("class", "acolor");
        get_con();
    });
    //刷新
    $("#sx_btn").click(function () {
        get_con();
    });
    //任务搜索
    $("#taskid").click(function () {
        var itemid = $("#taskinfo").val();
        if (isNaN(itemid)) {
            alert("请输入任务编号！");
            return false;
        }
    });

});

function get_con() {
    var w = "";
    $("#b2first a[class='acolor']").each(function () {
        w += $(this).attr("w");
    });
    var url = "/yptask/?catid=" + $("#catid").val() + "&w=" + w;
    window.location.href = url;

}