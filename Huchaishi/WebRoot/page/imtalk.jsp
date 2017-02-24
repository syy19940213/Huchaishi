<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="main-im">
    <div id="open_im" class="open-im" style="display: none;"></div>
    <div class="im_main" id="im_main">
        <div id="close_im" class="close-im"><a class="you" style="cursor: pointer" data-hasqtip="3" oldtitle="点击关闭" title=""></a></div>
       
        <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=240431307&amp;site=qq&amp;menu=yes" target="_blank" class="im-qq qq-a">
            <div class="qq-container"></div>
            <div class="qq-hover-c"><img class="img-qq" src="./img/qq.png"></div>
            <span>QQ在线咨询</span>
        </a>
        <div class="im-tel">
         <s:set name="username" value="#session.username"></s:set> 
	     <s:if test="#username == null"> 
	     	<div><a href="goindex" target="_blank" class="jsbz">网站公告</a></div>
	     </s:if>
	     <s:if test="#username != null"> 
	     	<div><a href="gonoticecenter" target="_blank" class="jsbz">网站公告</a></div>
	     </s:if>
            
        </div>
        <div class="im-footer" style="position:relative">
            <div class="go-top"><a class="you" style="cursor: pointer" data-hasqtip="4" oldtitle="返回顶部" title=""></a></div>
            <div style="clear:both"></div>
        </div>
    </div>
    <script>
        $(function () {
            $("#close_im").click(function () {
                $("#im_main").fadeOut(500, function () {
                    $("#open_im").fadeIn(500);
                });
            });
            $("#open_im").click(function () {
                $("#open_im").fadeOut(500, function () {
                    $("#im_main").fadeIn(500);
                });
            });
            $(".go-top").click(function () {
                $('html,body').animate({scrollTop: 0}, 800);
            });
        });
    </script>
</div>