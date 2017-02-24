<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>互差事</title>
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
</head>
<body class="rwdt_bg">
<div id="body" style="opacity: 1;">
   <jsp:include page="/page/header.jsp" /> 
<div class="banner">
    <div class="slide-main" id="touchMain">
        <a class="prev" href="javascript:;" stat="prev1001"><img src="./img/l-btn.png"></a>
        <div class="slide-box" id="slideContent">
            <div class="slide" id="bgstylec" style="display: none; opacity: 0.5; z-index: 0;">
                <div class="obj-e"><img src="./img/001.png"></div>
                <div class="obj-f"><img src="./img/002.png"></div>
            </div>
            <div class="slide" id="bgstylea" style="opacity: 0.5; z-index: 0; display: none;">
                <a stat="sslink-1" href="#" target="_blank">
                </a>
            </div>
            
        </div>
        <a class="next" href="javascript:;" stat="next1002"><img src="./img/r-btn.png"></a>
        <div class="item">
            <a class="" stat="item1001" href="javascript:;"></a><a href="javascript:;" stat="item1002" class=""></a>
        </div>
    </div>
   		 <s:set name="username" value="#session.username"></s:set> 
	     <s:if test="#username == null"> 
	      <div class="login_frame_bg">
		        <div class="login_frame">
		            <div id="myForm">
		                <form id="login" action="login.action" method="post">
		                    <table>
		                        <tbody><tr>
		                            <td>
		                                <div class="login_mailbox">
		                                    <input id="lusername" type="text" maxlength="26" name="userName" autocomplete="off" placeholder="用户名">
		                                </div>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td><p class="zq" id="miaoname" style="margin:-15px 0px 10px;"></p></td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <div class="login_ps">
		                                    <input id="lpassword" type="password" maxlength="16" name="userPassword" placeholder="请输入密码">
		                                </div>
		                            </td>
		                        </tr>
		                        <tr>
		                            <td><p id="miaopwd" class="zq" style="margin:-15px 0px 10px;"></p></td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <input class="login-btn" type="submit" name="submit" value="登录">
		                            </td>
		                        </tr>
		                        <tr>
		                            <td>
		                                <span><a href="goregiser">免费注册</a> <a id="forget_password" href="gofogetPage" target="_blank">忘记密码</a></span>
		                            </td>
		                        </tr>
		                    </tbody>
		                 </table>
		                </form>
		            </div>
		        </div>
		     </div>
	     </s:if>
       
    </div>
<div class="zt">
    <div class="anquan">
        <div id="why_choose">
            <div class="why_main">
                <div class="why_mainbody">
                    <table>
                        <tbody><tr>
                            <td><a id="lock_c" class="lock_c2" onmouseover="light(1)"></a></td>
                            <td id="z1"><a id="lock_d" class="lock_d" onmouseover="light(2)"></a></td>
                            <td align="right"><a id="lock_e" class="lock_e" onmouseover="light(3)"></a></td>
                        </tr>
                    </tbody></table>
                </div>
            </div>
            <div class="whyy">
                <div class="whyy1">
                    <p class="whyy1t" id="z2">安&nbsp;&nbsp;&nbsp;全</p>
                    <p id="z25"><span>会员专业：</span>接手经过严格的实名认证审核和培训</p>
                    <p id="z26">加入我们为您的店铺信誉保驾护航</p>
                    <p><span>来源真实：</span>全国各地真实IP帮您完成任务</p>
                </div>
                <div class="whyy1" id="z3">
                    <p class="whyy1t" id="z4">可&nbsp;&nbsp;&nbsp;靠</p>
                    <p id="z5"><span>减少降权：</span>结合旺旺聊天、搜索来路、停留时长</p>
                    <p id="z6">等特定条件有效减少80%降权风险</p>
                    <p><span>杜绝纠纷：</span>刷单平台作为中介为双方提供担保</p>
                </div>
                <div class="whyy1 tx">
                    <p class="whyy1t">贴&nbsp;&nbsp;&nbsp;心</p>
                    <p class="wd"><span>7×24 </span>小时系统稳定</p>
                    <p class="zx"><span>7×24 </span>小时客服在线</p>
                    <p class="zc"><span>7×24 </span>小时技术支持</p>
                </div>
            </div>
        </div>
    </div>

<script>
    $(function () {
        $('.pop_tip').slideDown(1000, function () {
            $(".pop_tip .ui_boxyClose").fadeIn(1000);
        });
        $('.pop_tip .ui_boxyClose').click(function () {
            $(".pop_tip").fadeOut(1000);
        });
    });
</script>
<style>
    .pop_tip {
        border-radius: 10px;
        background: #fff;
        border: 1px solid #666;
        position: fixed;
        bottom: 10px;
        right: 20px;
        z-index: 1000;
        box-shadow: 0 0 8px #000000;
        display: none;
    }
    .pop_tip .ui_boxyClose {
        display: none;
    }
</style>

<div style="clear:both;"></div>
<jsp:include page="/page/footer.jsp" />

</div>
<jsp:include page="/page/imtalk.jsp" />
</body></html>