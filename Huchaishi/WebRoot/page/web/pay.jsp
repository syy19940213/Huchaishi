<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<!-- saved from url=(0071)# -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="./css/combined.css" charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./css/thickboxpay.css" charset="UTF-8">
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="./js/thickbox.js"></script>
    <script type="text/javascript" src="./js/JScript.js"></script>
    <script type="text/javascript" src="./js/ZeroClipboard.js"></script>
    <title>支付宝付款</title>
    <script>
        $(document).ready(function () {
            var currentProCode = $("#currentProCode").val();
            var currentTab = $("#tab_" + currentProCode);
            currentTab.addClass("current");
            currentTab.siblings().removeClass("current");
            //var num = $(".select-tab li").index(currentTab);
            var num = currentTab.index();
            $(".contentwrap .paypanel").eq(num).show().siblings().hide();
            tb_show('注意事项', '#TB_inline?height=610&width=543&inlineId=TipWindow');
            setInterval(function () {
                $.ajax({
                    url: "/Demo.asp",
                    type: "post",
                    data: {act: "check", orderid: "266"},
                    success: function (d) {
                        if (d == "success") {
                            alert("支付成功！\n\n点击确定返回演示页面即可查看到您的付款记录");
                            location.href = "/Demo.asp";
                        }
                    }
                });
            }, 3000);
            var clip = new ZeroClipboard($('.clip_button'), {
                moviePath: '/file/script/ZeroClipboard.swf'
            });
            clip.on('ready', function () {
                this.on('aftercopy', function (event) {
                    $(event.target).next(".clip_tips").html("复制成功[" + event.data['text/plain'] + "]");
                });
            });
            clip.on('error', function (event) {
                alert('error[name="' + event.name + '"]: ' + event.message);
                ZeroClipboard.destroy();
            });
        })
    </script>
</head>
<body>
<div style="DISPLAY: none" id="TipWindow">
    
<div style="WIDTH: 513px; BACKGROUND: url(./img/tips.jpg); HEIGHT: 600px" class="TipWindow">
        <div>
            <ul class="clearfix">
                <li>2321</li>
                <li>266</li>
            </ul>
        </div>
        <a id="cat_Href" onclick="tb_remove();" href="#">我已知晓进入下一步》》</a></div></div>
<div class="headwrap">
    <div class="head clearfix">
        <ul>
            <li class="head_logo"><a href="login" target="_blank">网站首页</a></li>
            <li class="head_link"><a href="login" target="_blank">网站首页</a></li>
        </ul>
    </div>
</div>
<!--header结束-->
<div class="content">
    <div class="order">
        <div class="order_content detail">
            <ul class="clearfix">
                <li><b>付款金额：</b><strong>￥<s:property value="#session.Goldsum" /></strong>
                    <a class="clip_button" title="单击复制到剪贴板" data-clipboard-text="2321" onclick="window.clipboardData.setData(&#39;Text&#39;,&#39;2321&#39;);alert(&#39;复制成功！&#39;);return false;" href="#"></a> <span class="clip_tips"></span>
                </li>
                <li><b>收款人：</b><strong>chenyin19831012@163.com</strong>
                    <a class="clip_button" title="单击复制到剪贴板" data-clipboard-text="chenyin19831012@163.com" onclick="window.clipboardData.setData(&#39;Text&#39;,&#39;chenyin19831012@163.com&#39;);alert(&#39;复制成功！&#39;);"></a>
                    <span class="clip_tips"></span></li>
                <li><b>付款说明：</b><strong><s:property value="#session.id" /></strong>
                    <a class="clip_button" title="单击复制到剪贴板" data-clipboard-text="266" onclick="window.clipboardData.setData(&#39;Text&#39;,&#39;266&#39;);alert(&#39;复制成功！&#39;);"></a> <span class="clip_tips"></span></li>
            </ul>
            <div class="findetail">
                <a href="#">转账信息</a>
            </div>
        </div>
    </div>
    <input type="hidden" id="currentProCode" value="SP000001">
    <div class="select-tab">
        <ul>
            <li id="tab_SP000001" class="current"><a href="#">手机支付宝支付</a></li>
            <li id="tab_SP000002" class=""><a href="#">网页支付宝转账</a></li>
        </ul>
    </div>
    <div class="contentwrap">
        <div class="paypanel" style="display: block;">
            <div class="content_left">
                <h4><span>充值流程：确认充值账号后,打开手机支付宝扫描二维码向本站支付宝转账.</span></h4>
                <ul class="clearfix hided">
                    <li><span>1.首先打开手机支付宝钱包.</span></li>
                    <li><span>2.扫描本站支付宝二维码,并<strong>选择转账功能</strong></span></li>
                    <li><span>3.付款金额填写:<strong><s:property value="#session.Goldsum" /></strong></span></li>
                    <li><span>4.付款说明填写:<strong><s:property value="#session.id" /></strong></span></li>
                    <li><span>温馨提示：请勿修改付款金额付款说明<strong>否则不返数据</strong></span></li>
                    <li><span>到账时间：付款成功后,<strong>耐心等待10秒钟</strong>.</span></li>
                    <li><span><strong>注意事项：</strong>.</span></li>
                    <li><span><strong>1.请正确填写付款说明,否则无法自动到账.</strong>.</span></li>
                    <li><span><strong>2.本站支付宝账户会不定期更换,每次充值前请务必核对支付宝账号.</strong>.</span></li>
                </ul>
            </div>
            <div class="content_right_m">
                <img src="./img/QR.png" style="margin-top:20px; padding-top:20px;margin-left:20px; padding-left:20px">
            </div>
        </div>
        <div class="paypanel" style="display: none;">
            <div class="content_left">
                <h4><span>充值流程：确认充值账号后,登录网页支付宝向我们的支付宝转账.</span></h4>
                <ul class="clearfix">
                    <li><span>1.首先请登录网页支付宝.</span></li>
                    <li><span>2.向本站支付宝账号:<strong>chenyin19831012@163.com</strong> 转账
                             <strong>￥<s:property value="#session.Goldsum" /></strong> 元.</span></li>
                    <li><span>3.付款说明请填写:<strong><s:property value="#session.id" /></strong></span></li>
                    <li><span>温馨提示：请勿修改付款金额付款说明<strong>否则不返数据</strong></span></li>
                    <li><span>到账时间：付款成功后,<strong>耐心等待10秒钟</strong>.</span></li>
                    <li><span><strong>注意事项：</strong>.</span></li>
                    <li><span><strong>1.请正确填写付款说明,否则无法自动到账.</strong>.</span></li>
                    <li><span><strong>2.本站支付宝账户会不定期更换,每次充值前请务必核对支付宝账号.</strong></span></li>
                </ul>
                <div class="btn"><a target="_blank" href="https://auth.alipay.com/login/index.htm" id="sino_Href">登录支付宝付款</a></div>
            </div>
            <div class="content_right_pc">
                <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="410" height="410" id="alipay" align="middle">
                    <param name="movie" value="/file/ypcharge/css/img/alipay.swf">
                    <param name="quality" value="high">
                    <param name="bgcolor" value="#ffffff">
                    <param name="play" value="true">
                    <param name="loop" value="true">
                    <param name="wmode" value="window">
                    <param name="scale" value="showall">
                    <param name="menu" value="true">
                    <param name="devicefont" value="false">
                    <param name="salign" value="">
                    <param name="allowScriptAccess" value="sameDomain">
                    <!--<![endif]-->
                </object>
                <!--[if !IE]>-->
                <object type="" data="./img/alipay.swf" width="410" height="410">
                    <param name="movie" value="/file/ypcharge/css/img/alipay.swf">
                    <param name="quality" value="high">
                    <param name="bgcolor" value="#ffffff">
                    <param name="play" value="true">
                    <param name="loop" value="true">
                    <param name="wmode" value="window">
                    <param name="scale" value="showall">
                    <param name="menu" value="true">
                    <param name="devicefont" value="false">
                    <param name="salign" value="">
                    <param name="allowScriptAccess" value="sameDomain">
                    <!--<![endif]-->
                    <a href="#">
                        <img src="./img/get_flash_player.gif" alt="获得 Adobe Flash Player">
                    </a>
                    <!--[if !IE]>-->
                </object>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    <div class="foot-link">
    </div>
    <div class="copyright">Copyright 2016 All Rights Reserved</div>
</div>
<jsp:include page="/page/imtalk.jsp" />

<div id="global-zeroclipboard-html-bridge" class="global-zeroclipboard-container" style="position: absolute; left: 0px; top: -9999px; width: 1px; height: 1px; z-index: 999999999;"><object id="global-zeroclipboard-flash-bridge" name="global-zeroclipboard-flash-bridge" width="100%" height="100%" type="application/x-shockwave-flash" data="./img/ZeroClipboard.swf"><param name="allowScriptAccess" value="sameDomain"><param name="allowNetworking" value="all"><param name="menu" value="false"><param name="wmode" value="transparent"><param name="flashvars" value=""></object></div></body></html>