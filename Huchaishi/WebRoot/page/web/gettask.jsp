<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <title>互差事</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link rel="stylesheet" type="text/css" href="./css/css.css">
    <script type="text/javascript" src="./js/config.js"></script>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
    <script type="text/javascript" src="./js/admin.js"></script>
    <script type="text/javascript" src="./js/page.js"></script>
    <script type="text/javascript" src="./js/index.js"></script>
    <script type="text/javascript" src="./js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="./js/jquery.qtip.css"/>
    <script type="text/javascript" src="./js/jquery.qtip.js"></script>
    <script type="text/javascript" src="./js/layer/layer.js"></script>
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/ypfunction.js"></script>
    <script type="text/javascript" src="./js/sendtask.js" charset="UTF-8"></script>
  <script type="text/javascript">
	

	function cheakAccount(){
		

		if(cheakaccount()){
			if(cheaktaskGole()){
				return true;
			}else{
				return false;
			}
		}else{
			alert("请选择小号");
			return false;
		}

	}
	
	function cheakaccount(){
		
		var account = document.getElementById("taskUserAccount").value;
		
		if(account ==null || account==""){
			alert("请选择小号");
			return false;
		}else{
			return true;
		}
	}
	
	function cheaktaskGole(){
		var reward = document.getElementById("reward").value;
		var taskgold = document.getElementById("taskgold").value;
		var gold1 = Math.abs(reward);
		if(gold1==reward?true:false){
		}else{
			if(gold1>taskgold){
				alert("任务币不足");
				return false;
			}else{
				return true;
			}
		}
	}
	
</script>
</head>



<body class="rwdt_bg">
<div id="body">
 <jsp:include page="/page/header.jsp" /> 

<div class="h10"></div>

<div id="content">
  

    <form method="post" action="recivertask.action" onsubmit="return cheakAccount();" enctype="multipart/form-data">
       
        <div id="body_main">
          
            <div id="product" class="div fabu">
                <div id="menu_div">
                    <a style="border-left:none;cursor: pointer" class="on">任务信息</a>
                 
                    <span style="width:580px;height: 52px;border-bottom: 2px dashed #57a0ff;display: block;float: left;"></span>
                </div>
                <div id="product_main" class="product_con">
                    <div class="pt">
						<span class="h40">
							<img class="h41" src="./img/blue.png" alt="">任务信息：
						</span>
                    </div>
                    <table class="fields_item" id="tableadd">
                        <tbody>
                        	<tr>
								<td class="tl">
									<span class="f_red">*</span><span class="title">任务编号</span>
								</td>
								<td class="tr">
									<input id ="taskgold" style="display:none;" value="<s:property value='#session.taskgold' />"></input>
									<input  name="taskId" readonly= "true "  value="${task.taskId }" />			
								</td>
							</tr>
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">所属分类</span></td>
								<td class="tr">
									<span id="dcatid" class="f_red">
										<s:if test="#task.taskType==1">
											淘宝任务
										</s:if>
										<s:if test="#task.taskType==2">
											流量任务
										</s:if>
										<s:if test="#task.taskType==3">
											互助销量
										</s:if>
										<s:if test="#task.taskType==4">
											互助流量
										</s:if>
									</span>
								</td>
							</tr>
							<tr>
								<td class="tl">
									<span class="f_red">*</span><span class="title">选择小号</span>
								</td>
								<td class="tr">
									<select name="taskUserAccount" id="taskUserAccount">
									
										<s:iterator value="#xiaohao" var ="account">
										
											<s:if test="#account.boundAccountstatus==2">
												<option value="${account.boundAccount }">${account.boundAccount }</option>
											</s:if>
											
										</s:iterator>
										
									</select>  
								</td>
							</tr>
							<tr>
								<td class="tl"><span class="title">商品主图</span></td>
								<td class="tr">
									<img onMouseOver="showDiv1()" onMouseOut="hideDiv1()" src='<s:property value="#task.taskGoodsPictur" />' alt='商品略缩图' width='100' height='75'>
								</td>
								<style>
									#localImag1 {display:none; width:600px; height: 450px; border: 1px solid #D4CD49; position:fixed;left:40%;top:20% }
								</style>
								<div id="localImag1"  onMouseOut="hideDiv1()"><img width='600' height='450' src='<s:property value="#task.taskGoodsPictur" />'  id="preview"  style="display: block;"></div>
							</tr>
							<tr>
								<td class="tl"><span class="title">要求图片</span></td>
								<td class="tr">
									<img onMouseOver="showDiv()" onMouseOut="hideDiv()" src='<s:property value="#task.taskRequirePictur" />' alt='商品略缩图' width='100' height='75'>
								</td>
								<style>
									#localImag {display:none; width:600px; height: 450px; border: 1px solid #D4CD49; position:fixed;left:40%;top:20% }
								</style>
								<div id="localImag" ><img width='600' height='450' src='<s:property value="#task.taskRequirePictur" />'  id="preview"  style="display: block;"></div>
							</tr>
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">商品价格</span></td>
								<td class="tr">
									<span class="f_red"><s:property value="#task.taskGoodsPrice" /> </span>
								</td>
							</tr>
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">手机单/电脑单</span></td>
								<td class="tr">
									<span id="dcatid" class="f_red">
										<s:if test="#task.taskPhoneOrPc==1">
											电脑单
										</s:if>
										<s:if test="#task.taskPhoneOrPc==2">
											手机单
										</s:if>
									</span>
								</td>
							</tr>
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">信誉要求</span></td>
								<td class="tr">
									<span id="dcatid" class="f_red">
										<span class="xin<s:property value="#task.taskCredit" />"></span>
									</span>
								</td>
							</tr>	
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">任务发布人</span></td>
								<td class="tr">
									<span id="dcatid" class="f_red"><s:property value="#task.taskSendUser" /></span>
								</td>
							</tr>	
							
							<tr>
								<s:if test="#task.taskType==1">
									<td class="tl"><span class="f_red">*</span> <span class="title">任务奖励</span></td>
									<td class="tr">
										<span id="dcatid" class="f_red"><s:property value="#task.taskReward" />金币</span>
									</td>
								</s:if>
								<s:if test="#task.taskType==2">
									<td class="tl"><span class="f_red">*</span> <span class="title">任务奖励</span></td>
									<td class="tr">
										<span id="dcatid" class="f_red"><s:property value="#task.taskReward" />金币</span>
									</td>
								</s:if>
										
							</tr>
							<tr>	
								<s:if test="#message!=null">
									   <span class="f_red">${message }</span>
								</s:if>
								<s:if test="#meesage1!=null">
									   <span class="f_red">${meesage1 }</span>
								</s:if>
							</tr>
						
						</tbody>
                    </table>
                    <div style="clear:both;"></div>
                </div>
            </div>
          
           
             <div class="sudiv">
                <input id="btnCilentAdd" class="button abtn7" value="立即接受" type="submit">
            </div>
                    </div>
    </form>
</div>
<div style="clear:both;"></div>
<jsp:include page="/page/footer.jsp" />
</div>
<jsp:include page="/page/imtalk.jsp" />
</body>
</html>