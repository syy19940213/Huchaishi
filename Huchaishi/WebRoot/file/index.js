$(function () {
//弹出注册流程图片
    $(".t11").mouseover(function () {
        $(this).find(".t111 div").fadeIn(200)
    });
    $(".t11").mouseleave(function () {
        $(this).find(".t111 div").fadeOut(200)
    });
});


//点亮按钮
function light(a) {
    if (a == 1) {
        $("#lock_c").attr("class", "lock_c2");
        $("#lock_d").attr("class", "lock_d");
        $("#lock_e").attr("class", "lock_e");
    }
    if (a == 2) {
        $("#lock_c").attr("class", "lock_c");
        $("#lock_d").attr("class", "lock_d2");
        $("#lock_e").attr("class", "lock_e");
    }
    if (a == 3) {
        $("#lock_c").attr("class", "lock_c");
        $("#lock_d").attr("class", "lock_d");
        $("#lock_e").attr("class", "lock_e2");
    }
};

$(function () {
    var t;
    $(".js-change").mouseover(function () {
        t = $(this).attr("src");
        $(this).attr("src", $(this).attr("data-t"));
        $(this).attr("data-t", t);
    });
    $(".js-change").mouseleave(function () {
        t = $(this).attr("src");
        $(this).attr("src", $(this).attr("data-t"));
        $(this).attr("data-t", t);
    });
});

