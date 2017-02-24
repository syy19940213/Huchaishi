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
    <dd><a href="goaccountlist" class="active">账号绑定管理</a></dd>
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
       <h2 class="fl">账号审核列表</h2>
      </div>
      <table class="table">
       <tr>
        <th>用户编号</th>
        <th>用户名称</th>
        <th>绑定小号</th>
        <th>小号信誉</th>
        <th>小号图片</th>
        <th>审核状态</th>
        <th>操作</th>
       </tr>
       <s:iterator value="#accountList" var ="account">
       		 <tr>
		        <td>${account.userId }</td>
		        <td>${account.userName }</td>
		        <td>${account.boundAccount }</td>
		         <td>
		        				<s:if test="#account.boundAccountcredit == 1">
									一心
								</s:if>
								<s:if test="#account.boundAccountcredit == 2">
									二心
								</s:if>
								<s:if test="#account.boundAccountcredit == 3">
									三心
								</s:if>
								<s:if test="#account.boundAccountcredit == 4">
									四心
								</s:if>
								<s:if test="#account.boundAccountcredit == 5">
									五心
								</s:if>
								<s:if test="#account.boundAccountcredit == 6">
									砖石
								</s:if>
				</td>
				<td><a href="${account.boundAccountpicture}" target="view_window"><img alt="账号"  width="300px" height="250px" src="${account.boundAccountpicture}"></a></td>
		        <td>
		        	<s:if test="#account.boundAccountstatus == 1">
									审核中
					</s:if>
					<s:if test="#account.boundAccountstatus == 2">
									审核通过
					</s:if>
					<s:if test="#account.boundAccountstatus == 3">
									审核不通过
					</s:if>
				</td>
		       
		        <td>	
		        <s:if test="#account.boundAccountstatus == 1">
		        	<a href="passaccount.action?accountId=${account.id }" class="inner_btn">通过审核</a>
		        	<a href="notpassaccount.action?accountId=${account.id }" class="inner_btn">不通过审核</a>
		        </s:if>
		         
		        </td>
		     </tr>
       </s:iterator>
       
      
   
      </table>
     
 </div>
</section>
</body>
</html>
