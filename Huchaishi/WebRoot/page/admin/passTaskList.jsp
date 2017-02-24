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
    <dd><a href="goUserGoldList" >用户金币管理</a></dd>
    <dd><a href="gorecodeList">金币操作申请</a></dd>
     <dd><a href="gopassTaskList" class="active">任务确认列表</a></dd>
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
       <h2 class="fl">淘宝|流量任务管理</h2>
      </div>
      <table class="table">
       <tr>
      	<th>任务编号</th>
      	<th>任务类型</th>
        <th>发布人用户名</th>
        <th>接收人用户名</th>
        <th>任务发布时间</th>
        <th>任务接受时间</th>
        <th>操作</th>
       </tr>
       <s:iterator value="#taskList" var ="task">
       		<s:if test="#task.taskType == 1 || #task.taskType ==2">
       			<tr>
		        <td>${task.taskId }</td>
		        <td>
					<s:if test="#task.taskType==1">淘宝任务</s:if>
					<s:if test="#task.taskType==2">流量任务</s:if>
					<s:if test="#task.taskType==3">互助销量</s:if>
					<s:if test="#task.taskType==4">互助流量</s:if>
		        </td>
		        <td>${task.taskSendUser }</td>
		        <td>${task.taskGetUser }</td>
		        <td>${task.sendTime }</td>
		        <td>${task.getTime }</td>
		        <td>
		        
		         <s:if test="#task.taskStauts==4">
		         	<a href="passtask.action?taskId=${task.taskId }" class="inner_btn">确认放款</a>		 
		         </s:if>
		      
		        </td>
		     </tr>
       		</s:if> 
       </s:iterator>
      </table>
      
      <div class="page_title">
       <h2 class="fl">互助任务管理</h2>
      </div>
      <table class="table">
       <tr>
      	<th>任务编号</th>
      	<th>任务类型</th>
        <th>发布人用户名</th>
        <th>接收人用户名</th>
        <th>任务发布时间</th>
        <th>任务接受时间</th>
        <th>查看任务</th>
        <th>操作</th>
       </tr>
       <s:iterator value="#helpList" var ="task">
       	<s:if test="#task.taskStauts!=6">
       		<tr>
		        <td>${task.taskId }</td>
		        <td>
					<s:if test="#task.taskType==1">淘宝任务</s:if>
					<s:if test="#task.taskType==2">流量任务</s:if>
					<s:if test="#task.taskType==3">互助销量</s:if>
					<s:if test="#task.taskType==4">互助流量</s:if>
		        </td>
		        <td>${task.taskSendUser }</td>
		        <td>${task.taskGetUser }</td>
		        <td>${task.sendTime }</td>
		        <td>${task.getTime }</td>
		        <td>
		        	<a href="showtask.action?taskid=${task.taskId }">查看任务</a>
		        </td>
		        <td>
		        	
		      		<a href="delHelpTaskAction.action?taskId=${task.taskId }">删除任务</a>
		        </td>
		     </tr>
       	</s:if>
       		
       			
      
       		 
       </s:iterator>
       
      
   
      </table>
     
 </div>
</section>
</body>
</html>
