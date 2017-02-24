<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0040)# -->
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
	<div id="header" class="clean"></div>
	<div class="hyzx">
		<div class="hyzx_dh">
			<div class="hyzx_nav">
				<div class="menu persoanal_0">
				<div class="personal"><a id="edit" href="goUserManage.action">会员管理</a></div>  
					<div class="personal">
						<a id="edit" href="updatauser.action">修改资料</a>
					</div>
					<div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
					<div class="personal">
						<a id="gold" href="gogoldbuy" class="on"  >金币管理</a>
					</div>
					<div class="personal">
						<a id="taobaohao" href="goboundstore">绑定管理</a>
					</div>
					<div class="personal"><a id="gold" href="gotaskcenter.action">任务管理</a></div>
					<div class="personal">
						<a id="p-center" href="listcenter.action">个人中心</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="ypcon">
		<div class="menu">
			<table cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
				<td class="tab"><a id="m1" href="gogoldbuy" ><span>金币购买</span></a></td>
                <td class="tab"><a id="m2" href="goldchange.action" ><span>金币兑换</span></a></td>   
                 <td class="tab" id="action"><a id="m4" href="gold2money" class="sb0"><span>金币提现</span></a></td>
                <td class="tab" ><a id="m5" href="amountrecord"><span>金币记录</span></a></td>

               
					</tr>
				</tbody>
			</table>
		</div>
		<form method="post" action="changemoney.action">
			<table cellspacing="1" cellpadding="6" class="tb">
				<tbody>
					<tr>
						<td class="tl">我的帐户</td>
						<td class="tr">可用余额 <span class="f_red"></span> <s:property value="#session.gold"/> 元</td>
					</tr>
					<tr>
						<td class="tl"><span class="f_red">*</span>支付宝账号</td>
						<td class="tr"><input type="text" size="20" name="zhifubao"><span class="f_red">*提现账户必须跟注册名相同</span>
						</td>
					</tr>
					<tr>
						<td class="tl">提现说明</td>
						<td class="tr f_gray">- 24小时可提现次数1次<br>- 单次提现最小金额30元<br>-
							单次提现最大金额1000元<br>
						</td>
					</tr>
					<tr>
						<td class="tl"><span class="f_red">*</span>提现金额</td>
						<td class="tr"><input type="text" size="10" name="amountsum">
						</td>
					</tr>
					<tr>
						<td class="tl"></td>
						<td class="tr"><input type="submit" value=" 确 定 " class="btn">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="reset" name="reset" value=" 重 置 " class="btn">
							<s:if test="#success != null">
       							<s:property value="#success"/>
       						</s:if>
       					</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
			$(function() {
				set_nav("action", "sb0");
			});
		</script>
	</div>
	<script>
		$(function() {
			set_nav("record", "on");
		});
	</script>
	<div style="clear:both;"></div>
	<jsp:include page="/page/footer.jsp" />
	</div>
	<jsp:include page="/page/imtalk.jsp" />

</body>
</html>