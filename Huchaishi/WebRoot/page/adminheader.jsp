<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
	(function($){
		$(window).load(function(){
			
			$.ajax({  
				type: 'post',  
				url: 'findAllNum.action',
				dataType : 'json',
				error: function(XmlHttpRequest,textStatus,errorThrown){  
					
				},  
				
				success: function(data){ 
					var json = eval("("+data+")");
					console.log(json)
					console.log(json.account);
					document.getElementById("taskNum").innerHTML="<a href='gopassTaskList.action'  class='title'>任务待确认数【<span class='num'>"+json.task+"</span>】</a>";
					document.getElementById("goldNum").innerHTML="<a href='gorecodeList.action'  class='title'>金币待审核数【<span class='num'>"+json.gold+"</span>】</a>";
					document.getElementById("accountNum").innerHTML="<a href='goaccountlist.action' class='title'>账号待审核数【<span class='num'>"+json.account+"</span>】</a>";
					document.getElementById("storeNum").innerHTML="<a href='gostorelist.action'  class='title'>店铺待审核数【<span class='num'>"+json.store+"</span>】</a>";
					document.getElementById("applyNum").innerHTML="<a href='goAdminUserManage.action'  class='title'>会员待审核数【<span class='num'>"+json.apply+"</span>】</a>";
				}
				
			});
			
		});
	})(jQuery);
</script>

<header>
 <h1><img src="img/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li id="taskNum"></li>
  <li id="goldNum"></li>
  <li id="accountNum"></li>
  <li id="storeNum"></li>
  <li id="applyNum"></li>
  <li><a href="goindex.action" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="#" class="admin_icon">Admin</a></li>
 </ul>
</header>