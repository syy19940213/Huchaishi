<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
 <link rel="stylesheet" type="text/css" href="css/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="css/simditor.css" />

    <script type="text/javascript" src="scripts/js/jquery.min.js"></script>
    <script type="text/javascript" src="scripts/js/module.js"></script>
    <script type="text/javascript" src="scripts/js/uploader.js"></script>
    <script type="text/javascript" src="scripts/js/simditor.js"></script>
</head>
<body onload="goaccountlist.action">
<!--header-->
<jsp:include page="/page/adminheader.jsp" />
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 
 <ul>
   <li>	
   	<dl>
    <dt><a href="#" >首页</a></dt>
    </dl>
   	
   </li>
 		
  <li>
   <dl>
    <dt>用户信息</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="goAdminUserManage">会员审核管理</a></dd>
    <dd><a href="goaccountlist">账号绑定管理</a></dd>
    <dd><a href="gostorelist">店铺绑定管理</a></dd>
    <dd><a href="goUserGoldList">用户金币管理</a></dd>
    <dd><a href="gorecodeList">金币操作申请</a></dd>
     <dd><a href="gopassTaskList">任务确认列表</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>系统管理</dt>
    <dd><a href="gotaskmangelist">任务相关管理</a></dd>
    <dd><a href="goSystemList">跳转和推广设置</a></dd>
    <dd><a href="gochangePassword" class="active">修改系统密码</a></dd>
   </dl>
  </li>
   <li>
   <dl>
    <dt>公告管理</dt>
    <dd><a href="goListArticle"  >公告信息管理</a></dd>
   </dl>
  </li>
  
 </ul>
</aside>


<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
 <section>
 	<form action="changeAdminPassword" method="post">
      <h2><strong style="color:grey;">修改系统密码</strong></h2>
      <ul class="ulColumn2">
      	<s:if test = "#message!=null">
      		<span class="f_red">${message }</span>
      	</s:if>
      
       <li>
        <span class="item_name" style="width:120px;">原密码：</span>
        <input name="password" type="text" class="textbox textbox_295" />
       </li>
       <li>
        <span class="item_name" style="width:120px;">新密码：</span>
        <input name="newpassword" type="text" class="textbox textbox_295" />
       </li>
       
       <li>
        <span class="item_name" style="width:120px;"></span>
        <input type="submit" class="link_btn"/>
       </li>
      </ul>
      </form>
  </section>
 </div>
</section>
</body>
</html>
