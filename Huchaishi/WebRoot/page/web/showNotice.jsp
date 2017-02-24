<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gbk"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <title>互差事</title>
    <meta name="keywords" content="公告中心"/>
    <meta name="description" content="公告中心"/>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <script type="text/javascript" src="lang/zh-cn/lang.js"></script>
    <script type="text/javascript" src="file/config.js"></script>
    <script type="text/javascript" src="file/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="file/common.js"></script>
    <script type="text/javascript" src="file/admin.js"></script>
    <script type="text/javascript" src="file/page.js"></script>
    <script type="text/javascript" src="file/index.js"></script>
    <script type="text/javascript" src="file/main.js"></script>
    <link rel="stylesheet" type="text/css" href="file/jquery.qtip.css"/>
    <script type="text/javascript" src="file/jquery.qtip.js"></script>
    <script type="text/javascript" src="file/layer.js"></script>
    <script type="text/javascript" src="file/jquery.form.js"></script>
    <script type="text/javascript" src="file/ypfunction.js"></script>
    

</head>
<body class="rwdt_bg">
<div id="body">
    <jsp:include page="/page/header.jsp" /> 
   <style>
    .topBanner {
        width: 100%;
        height: 50px;
        line-height: 50px;
        font-size: 14px;
        background: #eee;
        border-bottom: 5px solid #1478C8;
    }
    .topBanner .topMenu {
        width: 1000px;
        margin: 0 auto;
        height: 50px;
    }
    .topBanner .topMenu .mbx {
        float: left;
        left: 10px;
        color: #333;
    }
    .topBanner .topMenu .mbx a {
        color: #333;
    }
    .topBanner .topMenu .bor {
        float: right;
    }
    .topBanner .topMenu .bor ul li {
        float: left;
        margin-right: 10px;
    }
    .topBanner .topMenu li a.item {
        display: inline-block;
        padding: 0px 8px;
        height: 32px;
        line-height: 32px;
        color: #434A54;
    }
    .topBanner .topMenu li a.itemcur {
        display: inline-block;
        padding: 0px 8px;
        height: 32px;
        line-height: 32px;
        color: #FFF;
        background: #1987DA;
        border-radius: 5px;
    }
    .item {
        position: static
    }
    .arcticle_h {
        width: 1024px;
        margin: 20px auto;
        padding: 20px;
        border: 1px dashed #99C1F5;
        border-radius: 5px;
        box-shadow: 0px 0px 10px #57A0FF;
        background: #fff;
    }
    .article_title {
        width: 1024px;
        margin: 0px auto 30px;
        text-align: center;
        font-size: 16px;
        padding-top: 30px;
    }
    .article_body {
        width: 1000px;
        margin: 0px auto;
        font-size: 16px;
        padding-bottom: 30px;
        line-height: 30px;
    }
    .newsList li {
        height: 50px;
        line-height: 50px;
        border-bottom: 1px dashed #99C1F5;
        font-size: 15px;
    }
    .newsList li a {
        color: #333
    }
    .newsList li span.spanTwo {
        color: #AAB2BD;
        float: right;
    }
</style>

<div class="arcticle_h">
        <div class="article_title">
        <h2>${artilc.aticleTitle }</h2>
    </div>
    <div class="article_body">
       ${artilc.aticleCenter }
       
        
    </div>
    </div>
<script>
    $(function () {
        set_nav("typeid0", "itemcur");
    });
</script>
<div style="clear:both;"></div>
   <jsp:include page="/page/footer.jsp" /> 
   <jsp:include page="/page/imtalk.jsp" />
</body>
</html>