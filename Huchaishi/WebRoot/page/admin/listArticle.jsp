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
<script>
	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
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
     <dd><a href="gochangePassword">修改系统密码</a></dd>
   </dl>
  </li>
   <li>
   <dl>
    <dt>公告管理</dt>
    <dd><a href="goListArticle"  class="active">公告信息管理</a></dd>
   </dl>
  </li>
  
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">

<div class="rt_content">
 	 <div class="page_title">
       <h2 class="fl">任务公告</h2>
      </div>
      <table class="table">
       <tr>
        <th>公告名称</th>
        <th>修改时间</th>
        <th>操作</th>
       
       </tr>
       <s:iterator value="#taskNotice" var ="aticle">
       		 <tr>
		        <th>${aticle.aticleTitle }</th>
		        <th>${aticle.aticleSenttime }</th>
		        <th>
		         <a href="goalterArticle?aticleId=${aticle.id }" class="inner_btn">修改</a>
		        </th>
		     </tr>
       </s:iterator>
       
      
   
      </table>
     
 </div>

 <div class="rt_content">
 	 <div class="page_title">
       <h2 class="fl">公告中心</h2>
       <a class="fr top_rt_btn" href="goaddArticle">添加公告</a>
      </div>
      <table class="table">
       <tr>
        <th>公告名称</th>
        <th>发布时间</th>
        <th>操作</th>
       
       </tr>
       <s:iterator value="#aticleList" var ="aticle">
       		 <tr>
		        <th>${aticle.aticleTitle }</th>
		        <th>${aticle.aticleSenttime }</th>
		        <th>
		         <a href="delArticle.action?aticleId=${aticle.id }" class="inner_btn">删除</a>
		        </th>
		     </tr>
       </s:iterator>
       
      
   
      </table>
     
 </div>
</section>
</body>
</html>
