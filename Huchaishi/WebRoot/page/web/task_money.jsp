<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)# -->
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
                <td class="tab" id="action"><a id="m3" href="#" class="sb0"><span>任务币记录</span></a></td>
            </tr>
			</tbody>
		</table>
    </div>
        <form action="#">
        
    </form>
    <div class="bd">
        <table cellpadding="1" cellspacing="0" class="tb">
            <tbody>
			<tr>
                <th>流水号</th>
                <th>收入/收入</th>
                <th>余额</th>
                <th width="130">发生时间</th>
                <th width="150">事由</th>
            </tr>
			<tr>
                <th>1</th>
                <th>+50</th>
                <th>50</th>
                <th width="130">2016/6/19 10:55</th>
                <th width="150">金币兑换</th>
            </tr>
			<tr>
                <th>2</th>
                <th>-10</th>
                <th>40</th>
                <th width="130">2016/6/19 15:55</th>
                <th width="150">任务发布</th>
            </tr>
          
        </tbody></table>
        <div id="page" class="pages"></div>
    </div>
    </div>
<script>
    /**/
    $(function () {
        set_nav("m3", "sb0");
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