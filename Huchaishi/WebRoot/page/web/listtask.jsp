<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0038)http://www.xyxshdq.com/yptask/?catid=4 -->
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>互差事</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="./css/css.css">
    <script type="text/javascript" src="./js/lang.js"></script>
    <script type="text/javascript" src="./js/config.js"></script>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
    <script type="text/javascript" src="./js/admin.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    <script type="text/javascript" src="./js/index.js"></script>
    <script type="text/javascript" src="./js/main.js"></script>
     <script type="text/javascript" src="./js/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/jquery.qtip.css">
    <script type="text/javascript" src="./js/jquery.qtip.js"></script>
    <script type="text/javascript" src="./js/layer.js"></script>
    <link rel="stylesheet" href="./css/layer.css" id="layui_layer_skinlayercss">
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/ypfunction.js"></script>
	<script type="text/javascript" src="./js/picture.js" ></script>
	<script type="text/javascript" src="./js/listtask.js" ></script>
	<script type="text/javascript" src="./js/sendtask.js" ></script>
	<style>
		*{margin:0;padding:0;list-style-type:none;}
		img,a{border:0;}
		.piccon{height:75px;}
		.piccon li{float:left;padding:0 10px;}
		#preview{position:absolute;border:1px solid #ccc;background:#333;padding:5px;display:none;color:#fff;}
	</style>
</head>
<body class="rwdt_bg" onload="searchtask(1,'','','')">

<div id="body" style="opacity: 1;">
	<input type="hidden" id="userlevel"  value="${sessionScope.userlevel}"/>
    <div id="top_yc"></div>
    <jsp:include page="/page/header.jsp" />
    <div class="rwdt_dh">
    <div class="menu">
        <div id="divon1"  class="divon">
        	<a class="nov" onclick="searchtask(1,'','','')"  title="">淘宝任务</a>
        	<a  onclick="searchtask(2,'','','')"  title="">流量任务</a>
        	<a  onclick="searchtask(3,'','','')"  title="">互助销量</a>
        	<a  onclick="searchtask(4,'','','')"   title="">互助流量</a>
        </div>

    </div>
    
    
</div>
<div class="h10"></div><script type="text/javascript" src="./js/yptask.js"></script>
<style type="text/css">  
    .model{  
            position: absolute; z-index: 1003;   
            width:600px; height:120px; text-align:center;  
            background-color:#ffffff; display: none;  
            border-color:#0000FF;
			border: 1px solid ;
        }  
    .head {
    	height:50px;
    }
    
    .head-left{
        margin-left: 20px;
    	margin-top: 10px;
    	float:left; 
    }
    
    .head-right{
    	margin-right: 20px;
    	margin-top: 10px;
    	float:right; 
    }

	.body{
		margin-left: 20px;
	}
          
</style>  

<script type="text/javascript">  
    //兼容火狐、IE8  
    function showMask(){  
        $("#mask").css("height",$(document).height());  
        $("#mask").css("width",$(document).width());  
        $("#mask").show();  
    }  
    //让指定的DIV始终显示在屏幕正中间  
    function letDivCenter(divName){   
        var top = ($(window).height() - $(divName).height())/2;   
        var left = ($(window).width() - $(divName).width())/2;   
        var scrollTop = $(document).scrollTop();   
        var scrollLeft = $(document).scrollLeft();   
        $(divName).css( { position : 'absolute', 'top' : top + scrollTop, left : left + scrollLeft } ).show();  
    }  
    function showAll(divName){  
        showMask();  
        letDivCenter(divName);  
    }  
    function hiddendiv(){
    	document.getElementById("model").style.display="none";
    }
</script> 
  


<div id="model" class="model"> 
	<div class="head">
		<div class="head-left">请选择一个小号：</div>
 		<div class="head-right"><a onClick="hiddendiv()">X</a></div>
	</div> 
	<div id="xiaohao" class="body">
		<a onclick="jierenwu('lhphzp');" class="accurl"><em class="iyellow">lhphzp</em><span class="xin0"></span></a>
	</div>
 	
</div>  





<div id="content">
	
    <div id="moveContent">
        <div>
            <div class="rwdt_xx">
                <div class="b21" id="b2first">
                    <table class="tb1">
                        <tbody>
                        <tr id = "cheak1">
                            <td class="leixing">任务类型：</td>
                            <td class="tb111">
                                <a w="0" class="acolor" onclick="searchtask('','all','','')">不限</a>
                            </td>
                            <td><a w="1" data-hasqtip="5"  title="" onclick="searchtask('',2,'','')">手机单</a></td>
                            <td><a w="2" data-hasqtip="6"  title="" onclick="searchtask('',1,'','')">电脑单</a></td>
                        </tr>
                        <tr id ="cheak2">
                            <td class="leixing">信誉要求：</td>
                            <td class="tb111"><a w="0" class="acolor" onclick="searchtask('','','all','')" >不限</a>
                            </td>
                            <td><a w="1" onclick="searchtask('','',1,'')"> <span class="xin1"></span> </a></td>
                            <td><a w="2" onclick="searchtask('','',2,'')"> <span class="xin2"></span> </a></td>
                            <td><a w="3" onclick="searchtask('','',3,'')"> <span class="xin3"></span> </a></td>
                            <td><a w="4" onclick="searchtask('','',4,'')"> <span class="xin4"></span> </a></td>
                            <td><a w="5" onclick="searchtask('','',5,'')"> <span class="xin5"></span> </a></td>
							<td><a w="6" onclick="searchtask('','',6,'')"> <span class="xin6"></span> </a></td>
                        </tr>
                       
                        <tr id ="cheak3">
                            <td class="leixing">任务金额：</td>
                            <td class="tb111">
                                <a w="0" class="acolor" onclick="searchtask('','','','all')">不限</a>
                            </td>
                            <td><a w="1" onclick="searchtask('','','',1)">50元以下</a></td>
                            <td><a w="2" onclick="searchtask('','','',2)">50-100元</a></td>
                            <td><a w="3" onclick="searchtask('','','',3)">100-200元</a></td>
                            <td><a w="4" onclick="searchtask('','','',4)">200-300元</a></td>
                            <td><a w="5" onclick="searchtask('','','',5)">300-400元</a></td>
							<td><a w="6" onclick="searchtask('','','',6)">400元以上</a></td>
                        </tr>
                        
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="rwdt_pf">
                <div class="c3" id="rwdt_float">
                    <ul>
                      
                        <li class="c37">
                         	 <a href="javascript:void(0);" class="button bg-sub anniu_fs" onclick="checkuser(<s:property value='#session.userlevel'/>)">发布任务</a>
                        </li>
                        <li class="c36">
                            <a class="sx_btn button bg-blue anniu_fs" id="sx_btn">刷新任务</a>
                        </li>
                    </ul>
                    
                    <div class="yptip">
                    	${aticle.aticleCenter }
                    </div>
                                                                                
                  </div>
            </div>
       
            <div class="cle"></div>
            <div id="taobao-lists">
            
                <div id="taskList">
                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tbody id="tasktable" class="tlisttable table-row">
                         
                                           
                         </tbody>
                     </table>
                      
                  </div>
                   
                    <div id="page">
                                            </div>
                </div>
            </div>
        </div>
    </div> 
    
    
   
</div>

<script type="text/javascript">
 var img = document.getElementById('img');
 function bigger(){
  img.style.width = '400px';
  img.style.height = '400px';
 }
 
 function smaller(){
  img.style.width = '100px';
  img.style.height = '100px';
 }

</script>
<style>
    #dialog {
        background-color: #FFF;
        display: none;
        width: 520px;
        border: solid #fff 1px;
    }
</style>

<input type="hidden" id="loginAccount" value ="<s:property value='#session.username'/>"> </input>

<script>
    $(function () {
        /**/
        set_nav("yptask23", "nov");
        /**/
    });
</script>
<div style="clear:both;"></div>
<jsp:include page="/page/footer.jsp" />
</div><div id="qtip-blanket" style="position: fixed; top: 0px; left: 0px; height: 100%; width: 100%; opacity: 0.2; z-index: 5000; display: none; background-color: black;"></div>
<jsp:include page="/page/imtalk.jsp" />
<script type="text/javascript">
    show_task('moduleid=23&html=index');
</script><script type="text/javascript" src="./task_files/task.js.php"></script>

<div id="qtip-249" class="qtip qtip-default qtip-bootstrap qtip-pos-tr" tracking="false" role="alert" aria-live="polite" aria-atomic="false" aria-describedby="qtip-249-content" aria-hidden="true" data-qtip-id="249" style="z-index: 15001;"><div class="qtip-content" id="qtip-249-content" aria-atomic="true">点击关闭</div></div></body></html>