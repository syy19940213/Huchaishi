<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0030)http://www.xyxshdq.com/member/ -->
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
    <!-- <script type="text/javascript" src="./js/layer.js"></script><link rel="stylesheet" href="./css/layer.css" id="layui_layer_skinlayercss"> -->
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/ypfunction.js"></script>
</head>
<body class="rwdt_bg">
<jsp:include page="/page/header.jsp" /> 
    
    <!--logo开始-->
    <div id="header" class="clean">       
    </div><script>
</script>
<div id="content_wrapper">
    <div class="hyzx">
    <div class="hyzx_dh">
        <div class="hyzx_nav">
            <div class="menu persoanal_0">
            <div class="personal"><a id="edit" href="goUserManage.action">会员管理</a></div>  
                <div class="personal"><a id="edit" href="updatauser.action">修改资料</a></div>                
                <div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
                <div class="personal"><a id="gold" href="gogoldbuy">金币管理</a></div>
                <div class="personal"><a id="taobaohao" href="goboundstore" >绑定管理</a></div>
                <div class="personal"><a id="gold" href="gotaskcenter.action">任务管理</a></div>
				<div class="personal"><a id="p-center" href="listcenter.action"  class="on">个人中心</a></div>
            </div>
        </div>
    </div>
</div>    <div class="personal1">
        <div class="personal2">
            <div class="personal3">
                <div class="per32 ez-fl"><a href="#"><img src="./img/default.jpg" alt="" height="100" width="100"></a>
                </div>
                <div class="per31 ez-fl">
                    <div class="per_nav">
                        <ul>
                            <li class="yhm"><s:property value="#session.username"/> 
                            	<span class="f_red">
								<s:if test="#session.userLevel==0">
									非会员
								</s:if> 
								<s:if test="#session.userLevel==1">
									普通会员
								</s:if> 
								<s:if test="#session.userLevel==2">
									高级会员
								</s:if>       
								</span>               
                            </li>
                            <li class="jyz">金币： <s:property value="#session.gold" />元</li>
                        </ul>
                    </div>
                    <div class="per311">
                        <ul>
                                                                                                                <li><a href="goboundstore.action" target="_blank" style="color: #57a0ff;">绑定掌柜</a><em class="suess"></em></li>
                                                                                                                                                                                                                            </ul>
                    </div>
                </div>
                <div class="per321 ez-fl">
                                       
                 
                                    </div>
            </div>
            <div class="per4">
                <div class="per41">
                    <div class="per411 ez-fl">
                        <span class="per412">&nbsp;&nbsp;&nbsp;&nbsp;任务币</span>
                        <span class="per414"><s:property value="#session.taskgold" /><span class="per415">个</span></span>
                        <span class="per417"><a href="goldchange.action">充值</a>    &nbsp;&nbsp;&nbsp;&nbsp;|     &nbsp;&nbsp;&nbsp;&nbsp;  <a href="gotaskgoldrecord">明细</a></span>
                    </div>
                    <div class="per421 ">
                        <span class="per412">&nbsp;&nbsp;&nbsp;&nbsp;金币</span>
                        <span class="per414"><s:property value="#session.gold" /><span class="per415">元</span></span>
                        <span class="per417"><a href="gogoldbuy">购买</a>    &nbsp;&nbsp;&nbsp;&nbsp;  |   &nbsp;&nbsp;&nbsp;&nbsp;    <a href="wdset.action">回收</a>  &nbsp;&nbsp;&nbsp;&nbsp; |     &nbsp;&nbsp;&nbsp;&nbsp;  <a href="amountrecord">明细</a></span>
                    </div>
                </div>
               
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        set_nav("m1", "on");
    });
</script>
<div style="clear:both;"></div>

        <jsp:include page="/page/footer.jsp" />
   
</div>
<jsp:include page="/page/imtalk.jsp" />

</body></html>