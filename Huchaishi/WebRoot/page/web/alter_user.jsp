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
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
<script type="text/javascript" src="./js/admin.js"></script>
<script type="text/javascript" src="./js/member.js"></script>
<link rel="stylesheet" type="text/css" href="./css/jquery.qtip.css">
<script type="text/javascript" src="./js/jquery.qtip.js"></script>
<script type="text/javascript" src="./js/ypfunction.js"></script>
</head>
<body class="rwdt_bg">
	<jsp:include page="/page/header.jsp" />

	</div>
	</div>
	</div>
	<!--logo开始-->
	<div class="hyzx">
		<div class="hyzx_dh">
			<div class="hyzx_nav">
				<div class="menu persoanal_0">
				<div class="personal"><a id="gold" href="goUserManage.action">会员管理</a></div>  
                <div class="personal"><a id="edit" href="updatauser.action" class="on">修改资料</a></div> 
                <div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>               
                <div class="personal"><a id="credit" href="gogoldbuy">金币管理</a></div>
                <div class="personal"><a id="taobaohao" href="goboundstore" >绑定管理</a></div>
                <div class="personal"><a id="gold" href="gotaskcenter.action">任务管理</a></div>
				<div class="personal"><a id="p-center" href="listcenter.action" >个人中心</a></div>
				</div>
			</div>
		</div>
	</div>
	<div id="ypcon">
		<script type="text/javascript" src="./js/profile.js"></script>
		<div class="menu">
			<table cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="tab_on" id="Tab0"><a
							onclick="$(this).parent().parent().find(&#39;a&#39;).removeAttr(&#39;class&#39;);$(this).attr(&#39;class&#39;,&#39;sb0&#39;);"
							href="javascript:Tab(0);" class="sb0"><span>个人资料</span> </a></td>
						<td class="tab" id="Tab1"><a
							onclick="$(this).parent().parent().find(&#39;a&#39;).removeAttr(&#39;class&#39;);$(this).attr(&#39;class&#39;,&#39;sb0&#39;);"
							href="javascript:Tab(1);"><span>密码管理</span> </a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<s:form action="alteruser.action" method="post"  onsubmit="return Dcheck();" id="dform">
			<input type="hidden" name="userid" id="userid" value="${user.id }">
			<table cellpadding="6" cellspacing="1" class="tb">
				<tbody id="Tabs0">
					<tr>
						<s:if test="#message!=null">
							${message }
						</s:if>
					</tr>
					<tr>
						<td class="tl">会员名</td>
						<td class="tr f_b">${user.userName }</td>
					</tr>
					<tr>
						<td class="tl"><span class="f_red">*</span>Email</td>
						<td class="tr f_b">${user.email }</td>
					</tr>
					<tr>
						<td class="tl"><span class="f_red">*</span>真实姓名</td>
						<td class="tr f_b">${user.realName }</td>
						
					</tr>
					
					<tr>
						<td class="tl">手机号码</td>
						<td class="tr f_b">${user.phoneNum }</td>
					</tr>
					<tr>
						<td class="tl">QQ</td>
						<td class="tr f_b">${user.userQq }</td>
					</tr>	
					<tr>
						<td class="tl"></td>
						<td class="tr f_b"><span class="f_red">*如有需要修改，请联系后台管理员</span></td>
					</tr>					
				</tbody>
				<tbody id="Tabs1" style="display: none;">
					<tr>
						<td class="tl">新登录密码</td>
						<td class="tr"><input type="password" size="20"
							name="password" id="password"
							onblur="validator(&#39;password&#39;);" autocomplete="off">&nbsp;<span
							class="f_gray">如不更改密码,请留空</span> </span></td>
					</tr>
					<!-- <tr>
						<td class="tl">重复新密码</td>
						<td class="tr"><input type="password" size="20"
							name="post[cpassword]" id="cpassword" autocomplete="off">&nbsp;<span
							id="dcpassword" class="f_red"></span></td>
					</tr>	 -->
													
				</tbody>
				<tbody>
					<tr>
						<td class="tl">&nbsp;</td>
						<td class="tr" height="30"><input type="submit" name="submit"
							value="保 存 " class="btn">&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="button" value=" 返 回 " class="btn"
							onclick="history.back(-1);">
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</div>
	<script type="text/javascript" src="./js/clear.js"></script>
	<script type="text/javascript">
var vid = '';
function validator(id) {
if(!Dd(id).value) return false;
vid = id;
makeRequest('moduleid=2&action=member&job='+id+'&value='+Dd(id).value+'&userid=332', AJPath, '_validator');
}
function _validator() {
if(xmlHttp.readyState==4 && xmlHttp.status==200) {
Dd('d'+vid).innerHTML = xmlHttp.responseText ? xmlHttp.responseText : '';
}
}
function Dcheck() {
if(Dd('truename').value == '') {
Tab(0);
Dmsg('请填写真实姓名', 'truename');
return false;
}
if(Dd('password').value != '') {
if(Dd('cpassword').value == '') {
Tab(1);
Dmsg('请重复输入密码', 'cpassword');
return false;
}
if(Dd('password').value != Dd('cpassword').value) {
Tab(1);
Dmsg('两次输入的密码不一致', 'password');
return false;
}
if(Dd('oldpassword').value == '') {
Tab(1);
Dmsg('请输入密码', 'oldpassword');
return false;
}
}
if(Dd('payword').value != '') {
if(Dd('cpayword').value == '') {
Tab(1);
Dmsg('请重复输入支付密码', 'cpayword');
return false;
}
if(Dd('payword').value != Dd('cpayword').value) {
Tab(1);
Dmsg('两次输入的支付密码不一致', 'payword');
return false;
}
if(Dd('oldpayword').value == '') {
Tab(1);
Dmsg('请输入支付密码', 'oldpayword');
return false;
}
}
if(Dd('type').value == '') {
Tab(2);
Dmsg('请选择商铺类型', 'type');
return false;
}
if(Dd('areaid_1').value == 0) {
Tab(2);
Dmsg('请选择商铺所在地', 'areaid');
return false;
}
if(Dd('catid').value.length < 2) {
Tab(2);
Dmsg('请选择商铺主营行业', 'catid');
return false;
}
if(Dd('business').value.length < 10) {
Tab(2);
Dmsg('主要经营范围最少10字', 'business');
return false;
}
if(Dd('regyear').value.length < 4) {
Tab(2);
Dmsg('请填写商铺成立年份', 'regyear');
return false;
}
if(Dd('daddress').value.length < 5) {
Tab(3);
Dmsg('请填写商铺地址', 'daddress');
return false;
}
if(Dd('telephone').value.length < 6) {
Tab(3);
Dmsg('请填写商铺电话', 'telephone');
return false;
}
if(FCKLen('introduce') < 10) {
Tab(4);
Dmsg('商铺介绍不能少于10字，当前已经输入'+FCKLen('introduce')+'字', 'introduce');
return false;
}
return true;
}
</script>
	<script>
$(function(){set_nav("edit","on");});
</script>
	<div style="clear:both;"></div>
	<div id="footer">
		<jsp:include page="/page/footer.jsp" />
	</div>
	</div>
	<jsp:include page="/page/imtalk.jsp" />

</body>
</html>