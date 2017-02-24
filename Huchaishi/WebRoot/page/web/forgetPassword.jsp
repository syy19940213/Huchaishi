<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0045)# -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<script type="text/javascript">
 function check(){	
 	if(document.getElementById("username").value == ''){
		alert("请输入用户名");
		return false;
	}else if(document.getElementById("qq").value == ''){
		alert("请输入用户QQ");
		return false;
	}else if(document.getElementById("realName").value == ''){
		alert("请输入姓名");
		return false;
	}else if(document.getElementById("cardid").value == ''){
		alert("请输入身份证号");
		return false;
	}else if(document.getElementById("password").value == ''){
		alert("请输入新的登录密码");
		return false;
	}else{
		return true;
	}
 }
	
</script>
<body class="rwdt_bg" onload="boundstorelist.action">
	<jsp:include page="/page/header.jsp" />

	<!--logo开始-->
	<div id="header" class="clean"></div>
	<div class="hyzx">
		
	</div>
	<div id="ypcon">
		<div class="menu">
			<table cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
				
                <td class="tab"><a id="m3"  class="sb0"><span>找回密码</span></a></td>
               
						</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<form method="post" action="forgetPassword" onsubmit="return check();" id="dform">

			<table cellpadding="6" cellspacing="1" class="tb">
			<tbody>
			<tr>
				<td class="tl"><span class="f_red">*</span> 用户名</td>
				<td class="tr"><input type="text" size="20" name="username" id="username"> <span id="dusername" class="f_red"></span></td>
			</tr>
			<tr>
			<td class="tl"><span class="f_red">*</span> QQ</td>
			<td class="tr"><input type="text" size="30" name="qq" id="qq"> <span id="demail" class="f_red"></span> <span class="f_gray">请填写您注册时填写的QQ</span></td>
			</tr>
			<tr>
			<td class="tl"><span class="f_red">*</span>姓名</td>
			<td class="tr"><input type="text" size="30" name="realName" id="realName"> <span id="demail" class="f_red"></span> <span class="f_gray">请填写您注册时填写的姓名</span></td>
			</tr>
			<tr>
			<td class="tl"><span class="f_red">*</span>身份证号</td>
			<td class="tr"><input type="text" size="30" name="cardid" id="cardid"> <span id="demail" class="f_red"></span> <span class="f_gray">请填写您注册时填写的身份证号</span></td>
			</tr>
			<tr>
			<td class="tl"><span class="f_red">*</span> 新登录密码</td>
			<td class="tr"><input type="password" size="20" name="password" id="password"> <span id="dpassword" class="f_red"></span></td>
			</tr>
			<tr>
			<td class="tl">提示信息</td>
			<td class="tr">
				<s:if test="#message!=null">
					${message }
				</s:if>
			</td>
			</tr>
			</tbody>
			<tbody><tr>
			<td class="tl">&nbsp;</td>
			<td class="tr" height="30"><input type="submit" name="submit" value="确定" class="btn">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			</tbody></table>
	</form>
	<script>
    $(function () {
        set_nav("taobaohao", "on");
        /**/
        set_nav("m2", "sb0");
        /**/
    });
</script>
	<div style="clear:both;"></div>
	<jsp:include page="/page/footer.jsp" />
	</div>
	<jsp:include page="/page/imtalk.jsp" />
</body>
</html>