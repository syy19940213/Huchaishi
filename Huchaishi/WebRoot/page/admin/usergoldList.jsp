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
    <dd><a href="goUserGoldList" class="active">用户金币管理</a></dd>
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
    <dd><a href="goListArticle" >公告信息管理</a></dd>
   </dl>
  </li>
  
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
 	 <div class="page_title">
       <h2 class="fl">用户金币管理</h2>
       <s:if test="#message!=null">${message }</s:if>
      </div>
      <table class="table">
       <tr>
        <th>用户名称</th>
        <th>用户QQ</th>
        <th>用户姓名</th>
        <th>用户电话</th>
        <th>用户邮箱</th>
        <th>用户金币</th>
        <th>用户任务币</th>
        <th>用户推荐人</th>
        <th>黑名单</th>
        <th>操作</th>
       </tr>
       <s:iterator value="#userList" var ="user">
       		 <tr>
		        <td>${user.userName }</td>
		        <td>${user.userQq }</td>
		        <td>${user.realName }</td>
		        <td>${user.phoneNum }</td>
		        <td>${user.email }</td>
		        <td>${user.gold }</td>
		        <td>${user.taskGold }</td>
		        <td>${user.recommendUser }</td>
		        <td>	
		        	<s:if test="#user.blackUser == 1">
		        		否
		        	</s:if>
		        	<s:if test="#user.blackUser == 2">
		        		是
		        	</s:if>
		        </td>
		        <td>
		         <a href="delUser.action?userId=${user.id }" class="inner_btn">删除</a>
		         <a href="goeditusergold.action?userId=${user.id }" class="inner_btn">编辑</a>
		         <s:if test="#user.userLevel != 0">
		         	 <a href="removeUserMember.action?userId=${user.id }" class="inner_btn">解除会员</a>
		         </s:if>
		        
		         <s:if test="#user.blackUser==1">
		         	<a href="addblackuser.action?userId=${user.id }" class="inner_btn">加入黑名单</a>
		         </s:if>
		         <s:if test="#user.blackUser==2">
		         	<a href="delblackuser.action?userId=${user.id }" class="inner_btn">解除黑名单</a>
		         </s:if>
		        </td>
		     </tr>
       </s:iterator>
       
      
   
      </table>
     
 </div>
</section>
</body>
</html>
