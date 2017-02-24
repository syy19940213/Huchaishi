<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="top_yc"></div>
    <div class="ui-header ibj-header clean">
        <div class="ui-header-top" id="j-header-top">
            <div class="grid zbj-grid">
           
                <div class="fr ui-header-nav">
	               <s:set name="username" value="#session.username"></s:set> 
	                 <div class="ui-dropdown"> 
	                 	<s:set name="username" value="#session.username"></s:set> 
	                 	<s:if test="#username == null"> 
	                 		<span style="height: 35px;line-height: 35px;padding: 0 10px;">
	                        	 <a href="goindex">登录</a>  
	                        </span> 
	                    </s:if> 
	                </div> 
	                <div class="ui-dropdown"> 
	                 	<s:set name="username" value="#session.username"></s:set> 
	                 	<s:if test="#username == null"> 
	                 		<span style="height: 35px;line-height: 35px;padding: 0 10px;">
	                        	 <a href="goregiser">注册</a>  
	                        </span> 
	                    </s:if> 
	                </div> 
	                <div class="ui-dropdown"> 
	                 	<s:set name="username" value="#session.username"></s:set> 
	                 	<s:if test="#username != null"> 
	                 		<span style="height: 35px;line-height: 35px;padding: 0 10px;">
	                        	 <a href="#none">欢迎你: <s:property value="#session.username" /></a>  
	                        </span> 
	                    </s:if> 
	                </div> 
	                <div class="ui-dropdown"> 
	                 	<s:set name="username" value="#session.username"></s:set> 
	                 	<s:if test="#username != null"> 
	                 		<span style="height: 35px;line-height: 35px;padding: 0 10px;">
	                        	 <a href="logout.action">退出登录</a>  
	                        </span> 
	                    </s:if> 
	                </div> 
               
                  
                   
                  
                </div>
            </div>
        </div>
    </div>
    <!--logo开始-->
    <div id="header" class="clean">
        <div class="header_main">
            <div id="msgbox" style="display:none;"></div>
                        <div class="header_left">
                <a href="#"><img src="./img/logo.png" alt="互差事-国内正规安全淘宝刷单刷销量兼职网站平台"></a>
            </div>
            <div class="header_right">
                <ul id="m_menu">
 					<s:if test="#username == null"> 
 						<li><a href="goindex">首 页</a></li>
	                    <li><a href="goindex">任务大厅</a></li>
	                    <li><a href="goindex">推广链接</a></li>
	                    <li><a href="goindex">会员中心</a></li>
	                    <li><a href="goindex">公告中心</a></li>
 					</s:if>
 					<s:if test="#username != null"> 
 						<li><a href="goindex">首 页</a></li>
	                    <li><a href="gotaskList">任务大厅</a></li>
	                    <li><a href="gourl">推广链接</a></li>
	                    <li><a href="listcenter">会员中心</a></li>
	                    <li><a href="gonoticecenter">公告中心</a></li>
 					</s:if>
                    
                </ul>
            </div>
        </div>
    </div><script type="text/javascript">
    //手机访问
    /**/
    /**/
</script>