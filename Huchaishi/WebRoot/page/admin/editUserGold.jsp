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
    <dd><a href="goaccountlist" >账号绑定管理</a></dd>
    <dd><a href="gostorelist">店铺绑定管理</a></dd>
    <dd><a href="goUserGoldList">用户金币管理</a></dd>
    <dd><a href="gorecodeList">金币操作申请</a></dd>
     <dd><a href="gopassTaskList">任务确认列表</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>系统管理</dt>
    <dd><a href="gotaskmangelist" class="active">任务相关管理</a></dd>
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
 	<form method="post" action="updateUserGold">
 	<section>
 	
      <h2><strong style="color:grey;">修改任务相关信息</strong></h2>
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px;">用户名称：</span>
        <input name="userName" type="text" class="textbox textbox_295" value="${user.userName }" readonly="readonly" />
        
       </li>
       <li>
        <span class="item_name" style="width:120px;">用户QQ：</span>
        <input name="userQq" type="text" class="textbox textbox_295" value="${user.userQq }" />
        
       </li>
        <li>
        <span class="item_name" style="width:120px;">用户姓名：</span>
        <input name="realName" type="text" class="textbox textbox_295" value="${user.realName }" ></input>
        
       </li>
       <li>
        <span class="item_name" style="width:120px;">用户电话：</span>
        <input name="phoneNum" type="text" class="textbox textbox_295" value="${user.phoneNum }" ></input>
       </li>
        <li>
        <span class="item_name" style="width:120px;">用户邮箱：</span>
        <input name="email" type="text" class="textbox textbox_295" value="${user.email }" readonly="readonly"></input>
       </li>
        <li>
        <span class="item_name" style="width:120px;">用户金币：</span>
        <input name="gold" type="text" class="textbox textbox_295" value="${user.gold }"></input>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;">用户任务币：</span>
        <input name="taskGold" type="text" class="textbox textbox_295" value="${user.taskGold }"></input>
       </li>
      
       
       <li>
        
        <input type="submit" value="更新"></input>
       
       </li>
     </section>
     </form>
     
 </div>
</section>
</body>
</html>
