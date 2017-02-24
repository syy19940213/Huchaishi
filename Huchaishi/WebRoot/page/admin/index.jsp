<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
<body>
<!--header-->
	<jsp:include page="/page/adminheader.jsp" />

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 
 <ul>
   <li>	
   	<dl>
    <dt><a href="gostorelist" class="active">首页</a></dt>
    </dl>
   	
   </li>
 		
  <li>
   <dl>
    <dt>用户信息</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="goAdminUserManage">会员审核管理</a></dd>
    <dd><a href="goaccountlist">账号绑定管理</a></dd>
    <dd><a href="#">店铺绑定管理</a></dd>
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
     <!--开始：以下内容则可删除，仅为素材引用参考-->
     <h1 style="color:red;font-size:20px;font-weight:bold;text-align:center;">欢迎登陆后台管理系统</h1>
     
 </div>
</section>
</body>
</html>
