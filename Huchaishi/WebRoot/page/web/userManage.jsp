<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0054)# -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
    
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
    <script type="text/javascript" src="./js/userManage.js"></script>
</head>
<script type="text/javascript">
</script>
<body class="rwdt_bg">
<jsp:include page="/page/header.jsp" />   
    <!--logo开始-->
  <div id="header" class="clean">       
    </div><div class="hyzx">
    <div class="hyzx_dh">
        <div class="hyzx_nav">
            <div class="menu persoanal_0">
            	<div class="personal"><a id="edit" href="goUserManage.action" class="on">会员管理</a></div>    
                <div class="personal"><a id="edit" href="updatauser.action">修改资料</a></div>                
                <div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
                <div class="personal"><a id="gold" href="gogoldbuy" >金币管理</a></div>
                <div class="personal"><a id="taobaohao" href="goboundstore" >绑定管理</a></div>
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
                <td class="tab"><a id="m2" href="#" ><span>会员管理</span></a></td>   
               
            </tr>
        </tbody></table>
        
    </div>
        <form method="post" action="buytaskmoney" onsubmit="cheak()">
        <table cellspacing="1" cellpadding="6" class="tb">
            <tbody><tr>
                <td class="tl">普通会员</td>
                <td class="tr">
                	<span class="f_red">可发布接受互助任务</span>
                </td>
            </tr>
            <tr>
                <td class="tl">高级会员</td>
                <td class="tr c_p">
                    <table cellpadding="5" cellspacing="3">
                        <tbody>
                        <span class="f_red">可发布接受所有任务</span>
                        </tbody>
					</table>
                </td>
            </tr>
            <tr>
                <td class="tl">&nbsp;</td>
                <td class="tr" height="50">
                	<input type="button" name="touser" value="申请会员 " class="btn" onclick="aboutUser(1,<s:property value="#session.id"/> )">&nbsp;&nbsp;&nbsp;&nbsp;
                	<input type="button" name="removeuser" value="解除会员" class="btn" onclick="aboutUser(2,<s:property value="#session.id"/> )"><br/>
                	<span class="f_red">确认申请后请联系客服QQ在线审核</span>
                </td>
            </tr>
        </tbody></table>
    </form>
    </div>
<script>
    /**/
    $(function () {
        set_nav("m2", "sb0");
    });
    /**/
    /**/
    $(function () {
        set_nav("credit", "on");
    });
    /**/
</script>
<div style="clear:both;"></div>
<jsp:include page="/page/footer.jsp" />
</div>
<jsp:include page="/page/imtalk.jsp" />

</body></html>