$(function () {
    qtip_init();
    var dm = document.domain;
    var num = dm.lastIndexOf('.');
    var top_dm = dm.substring(0, num)
    num = top_dm.lastIndexOf('.');
    top_dm = document.domain.substring(num + 1, dm.length)
    var topaaa = new Array('top.com', 'topaaa.com');
    if($.inArray(top_dm, topaaa)!=-1){
        layer.tips('此处是后台的设置说明<br>管理员可以编辑或删除<br>用来给会员做提示信息', '.yptip', {
            tips: [2, '#197cfd'],
            time: 60000
        });
    }    
});
function qtip_init() {
    $("[title]").qtip({style: {classes: 'qtip-bootstrap'}});
    //在右侧的图标提示向左
    $(".you[title]").qtip({
        position: {
            my: 'top right',
            at: 'bottom left'
        },
        style: {
            classes: 'qtip-bootstrap'
        }
    });
}
/*  淡入淡出  */
$(function () {
    $("#body").css("opacity", 0).delay(400).animate({opacity: 1}, 400);//淡入淡出
    setInterval("get_notice()", 40000);//消息提醒
});
/*  公告滚动  */
$(function () {
    //单行应用@Mr.Think
    var _wrap = $('ul.line');//定义滚动区域
    var _interval = 4000;//定义滚动间隙时间
    var _moving;//需要清除的动画
    _wrap.hover(function () {
        clearInterval(_moving);//当鼠标在滚动区域中时，停止滚动
    }, function () {
        _moving = setInterval(function () {
            var _field = _wrap.find('li:first');//此变量不可放置于函数起始处，li:first取值是变化的
            var _h = _field.height();//取得每次滚动高度
            _field.animate({marginTop: -_h + 'px'}, 2000, function () {//通过取负margin值，隐藏第一行
                _field.css('marginTop', 0).appendTo(_wrap);//隐藏后，将该行的margin值置零，并插入到最后，实现无缝滚动
            })
        }, _interval)//滚动间隔时间取决于_interval
    }).trigger('mouseleave');//函数载入时，模拟执行mouseleave，即自动滚动
});
//当前导航
function set_nav(ele_id, ele_class) {
    $("#" + ele_id).attr("class", ele_class);
}
//消息提醒
function get_notice() {
    $.ajax({
        type: "GET",
        url: "/member/ypuserinfo.php",
        dataType: "json", cache: false,
        success: function (json) {
            if ($(".notice_box").size() == 0 && json.noticeid) {
                notice(json.noticeid);
            }
        }
    });
}
//提示
function notice(itemid) {
    var width = $(window).width();
    var height = $(window).height();
    var left = width / 2 - 150;
    var top = height / 2 - 60;
    var url = "/member/notice.php?itemid=" + itemid + "&ran=" + Math.random();
    var style = "style=\"left:" + left + "px;" + "top:" + top + "px;\"";
    var notice_box = '<div class="notice_box" ' + style + '><div class="ui_boxyClose" onclick="$(this).parent().fadeOut(500).delay(500).remove();"></div><div class="msg_logo">消息提醒</div><iframe src="' + url + '"frameborder="0" width="300" height="80" scrolling="no"></iframe></div>';
    $("body").append(notice_box);
    $(".notice_box").fadeIn(500);
}

//发布任务
function faburenwu(cat) {
    var cats, cur_cat;
    cats = cat.split(",");
    var v;
    var str = '';
    for (v in cats) {
        cur_cat = cats[v].split("|");
        str += '<a class="layui-layer-btn0" href="/member/my.php?mid=23&action=add&catid=' + cur_cat[0] + '">' + cur_cat[1] + '</a>';
    }
    layer.open({
        type: 1,
        area: ['360px', '160px'], //宽高
        title: '请选择要发布的任务类别',
        content: '<div class="layui-layer-btn faburenwu">' + str + '</div>'
    });
}

//保存截图
function submit_img(obj, itemid) {
    $.ajax({
        url: "/yptask/viewpro.php",
        data: {
            submit: 1,
            itemid: itemid,
            name: $(obj).prev().attr("name"),
            content: encodeURI($(obj).prev().val())
        },
        type: 'post',
        cache: false,
        success: function (data) {
            if (data == "success")alert("保存成功！");
            else alert("保存失败，原因：" + data);
        },
        error: function () {
            alert("异常！");
        }
    });
}

function img_upload(fid) {
    if (fid.indexOf('_') == -1) return true;
    var post_name;
    post_name = fid.substr(0, fid.lastIndexOf('_'));
    var img_arr = new Array();
    var itemid = $("#" + fid.replace('img_', 'thumb_')).attr("itemid");
    $("[name='" + post_name + "']").each(function () {
        if ($(this).val()) img_arr.push($(this).val());
    });
    var imgs;
    imgs = img_arr.join('|');
    $.ajax({
        url: "/yptask/viewpro.php",
        data: {
            submit: 1,
            itemid: itemid,
            name: post_name,
            content: imgs
        },
        type: 'post',
        cache: false,
        success: function (response) {
            if (response != "success") alert("保存失败，原因：" + data);
        },
        error: function () {
            alert("异常！");
        }
    });
}
function img_delete(filename) {
    if (filename != '') {
        makeRequest('action=clear_img&file=' + filename, AJPath);
    }
}