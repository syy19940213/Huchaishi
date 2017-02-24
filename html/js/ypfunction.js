$(function () {
    qtip_init();
    var dm = document.domain;
    var num = dm.lastIndexOf('.');
    var top_dm = dm.substring(0, num)
    num = top_dm.lastIndexOf('.');
    top_dm = document.domain.substring(num + 1, dm.length)
    var topaaa = new Array('top.com', 'topaaa.com');
    if($.inArray(top_dm, topaaa)!=-1){
        layer.tips('�˴��Ǻ�̨������˵��<br>����Ա���Ա༭��ɾ��<br>��������Ա����ʾ��Ϣ', '.yptip', {
            tips: [2, '#197cfd'],
            time: 60000
        });
    }    
});
function qtip_init() {
    $("[title]").qtip({style: {classes: 'qtip-bootstrap'}});
    //���Ҳ��ͼ����ʾ����
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
/*  ���뵭��  */
$(function () {
    $("#body").css("opacity", 0).delay(400).animate({opacity: 1}, 400);//���뵭��
    setInterval("get_notice()", 40000);//��Ϣ����
});
/*  �������  */
$(function () {
    //����Ӧ��@Mr.Think
    var _wrap = $('ul.line');//�����������
    var _interval = 4000;//���������϶ʱ��
    var _moving;//��Ҫ����Ķ���
    _wrap.hover(function () {
        clearInterval(_moving);//������ڹ���������ʱ��ֹͣ����
    }, function () {
        _moving = setInterval(function () {
            var _field = _wrap.find('li:first');//�˱������ɷ����ں�����ʼ����li:firstȡֵ�Ǳ仯��
            var _h = _field.height();//ȡ��ÿ�ι����߶�
            _field.animate({marginTop: -_h + 'px'}, 2000, function () {//ͨ��ȡ��marginֵ�����ص�һ��
                _field.css('marginTop', 0).appendTo(_wrap);//���غ󣬽����е�marginֵ���㣬�����뵽���ʵ���޷����
            })
        }, _interval)//�������ʱ��ȡ����_interval
    }).trigger('mouseleave');//��������ʱ��ģ��ִ��mouseleave�����Զ�����
});
//��ǰ����
function set_nav(ele_id, ele_class) {
    $("#" + ele_id).attr("class", ele_class);
}
//��Ϣ����
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
//��ʾ
function notice(itemid) {
    var width = $(window).width();
    var height = $(window).height();
    var left = width / 2 - 150;
    var top = height / 2 - 60;
    var url = "/member/notice.php?itemid=" + itemid + "&ran=" + Math.random();
    var style = "style=\"left:" + left + "px;" + "top:" + top + "px;\"";
    var notice_box = '<div class="notice_box" ' + style + '><div class="ui_boxyClose" onclick="$(this).parent().fadeOut(500).delay(500).remove();"></div><div class="msg_logo">��Ϣ����</div><iframe src="' + url + '"frameborder="0" width="300" height="80" scrolling="no"></iframe></div>';
    $("body").append(notice_box);
    $(".notice_box").fadeIn(500);
}

//��������
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
        area: ['360px', '160px'], //���
        title: '��ѡ��Ҫ�������������',
        content: '<div class="layui-layer-btn faburenwu">' + str + '</div>'
    });
}

//�����ͼ
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
            if (data == "success")alert("����ɹ���");
            else alert("����ʧ�ܣ�ԭ��" + data);
        },
        error: function () {
            alert("�쳣��");
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
            if (response != "success") alert("����ʧ�ܣ�ԭ��" + data);
        },
        error: function () {
            alert("�쳣��");
        }
    });
}
function img_delete(filename) {
    if (filename != '') {
        makeRequest('action=clear_img&file=' + filename, AJPath);
    }
}