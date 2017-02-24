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
    <dd><a href="goAdminUserManage" class="active">会员审核管理</a></dd>
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
    <dd><a href="goListArticle">公告信息管理</a></dd>
   </dl>
  </li>
  
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
 	 <div class="page_title">
       <h2 class="fl">会员审核管理</h2>
      </div>
      <table class="table">
       <tr>
        <th>用户编号</th>
        <th>用户名称</th>
        <th>用户QQ</th>
        <th>用户等级</th>
        <th>用户申请</th>
        <th>操作</th>
       </tr>
       <s:iterator value="#applyList" var ="apply">
       		 <tr>
		        <td>${apply.userId }</td>
		        <td>${apply.userName }</td>
		        <td>${apply.userQq }</td>
		        <td>${apply.userLevel }</td>
		        <td>${apply.userDo }</td>
		       
		        <td>	
		        	<a href="setUserMember.action?userId=${apply.userId }&userLevel=0&applyId=${apply.id }" class="inner_btn">解除会员</a>
		        	<a href="setUserMember.action?userId=${apply.userId }&userLevel=1&applyId=${apply.id }" class="inner_btn">普通会员</a>
		        	<a href="setUserMember.action?userId=${apply.userId }&userLevel=2&applyId=${apply.id }" class="inner_btn">高级会员</a>
		        
		         
		        </td>
		     </tr>
       </s:iterator>
       
      
   
      </table>
     
 </div>
</section>
</body>
</html>
