<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0055)# -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

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
<script type="text/javascript" src="./js/layer.js"></script>
<link rel="stylesheet" href="./css/layer.css"
	id="layui_layer_skinlayercss">
<script type="text/javascript" src="./js/jquery.form.js"></script>
<script type="text/javascript" src="./js/ypfunction.js"></script>
</head>
<body class="rwdt_bg">
	<jsp:include page="/page/header.jsp" />
	<!--logo开始-->
	<div id="header" class="clean">
		
	</div>
	<div class="hyzx">
		<div class="hyzx_dh">
			<div class="hyzx_nav">
				<div class="menu persoanal_0">
				<div class="personal"><a id="edit" href="goUserManage.action">会员管理</a></div>  
			 	<div class="personal"><a id="edit" href="updatauser.action">修改资料</a></div>                
                <div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
                <div class="personal"><a id="gold" href="gogoldbuy" class="on" >金币管理</a></div>
                <div class="personal"><a id="taobaohao" href="goboundstore" >绑定管理</a></div>
                <div class="personal"><a id="gold" href="gotaskcenter.action">任务管理</a></div>
				<div class="personal"><a id="p-center" href="listcenter.action" >个人中心</a></div>
				</div>
			</div>
		</div>
	</div>
	<div id="ypcon">
		<div class="menu">
			<table cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="tab"><a id="action" href="wdapplication"><span>申请提现</span>
						</a></td>
						<td class="tab_nav">&nbsp;</td>
						<td class="tab"><a id="action_record" href="wdrecord.action"><span>提现记录</span>
						</a></td>
						<td class="tab_nav">&nbsp;</td>
						<td class="tab"><a id="action_setting" href="wdset.action"
							class="sb0"><span>帐号设置</span> </a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<form method="post" action="#">
			<input type="hidden" name="action" value="setting">
			<table cellspacing="1" cellpadding="6" class="tb">
				<tbody>
					<tr>
						<td class="tl"><span class="f_red">*</span>支付宝</td>
						<td class="tr"><input type="text" size="30" name="zhifubao"
							value="15623637611"> [注意] 此帐号开户名必须为 <strong>湖大</strong></td>
					</tr>
					<tr>
						<td class="tl"><span class="f_red">*</span>财付通</td>
						<td class="tr"><input type="text" size="30" name="caifutong"
							value=""> [注意] 此帐号开户名必须为 <strong>湖大</strong></td>
					</tr>
					<tr>
						<td class="tl"><span class="f_red">*</span>支付密码</td>
						<td class="tr"><input name="password" type="password"
							class="inp input" style="width:158px;float: left" id="password">&nbsp;
								<!--<script type="text/javascript" src="./js/keyboard.js"></script>  -->
						<style>
#kb {
	position: absolute;
	z-index: 999;
	border: #7F9DB9 1px solid;
	background: #F1FAFF;
}

#kb input {
	padding: 1px 6px 1px 6px;
	cursor: pointer;
	font-size: 12px;
	width: 25px;
	height: 25px;
	line-height: 18px;
}
</style> <img src="" alt="" class="c_p"
							onclick="_k(&#39;password&#39;, &#39;kb&#39;, this);"
							data-hasqtip="1" oldtitle="密码键盘" title="">
							<div id="kb" style="display:none;"></div> <script
								type="text/javascript" src="./js/md5.js"></script> <script
								type="text/javascript">init_md5();</script>
						</td>
					</tr>
					<tr>
						<td class="tl"></td>
						<td class="tr"><input type="submit" name="submit"
							value=" 确 定 " class="btn">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" name="reset" value=" 重 置 " class="btn">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
        $(function () {
            set_nav("action_setting", "sb0");
        });
    </script>
	</div>
	<script>
    $(function () {
        set_nav("record", "on");
    });
</script>
	<div style="clear:both;"></div>
	<jsp:include page="/page/footer.jsp" />
	</div>
	<jsp:include page="/page/imtalk.jsp" />

</body>
</html>