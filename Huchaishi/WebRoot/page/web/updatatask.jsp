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
    <link rel="stylesheet" type="text/css" href="./css/jquery.qtip.css"/>
    <script type="text/javascript" src="./js/jquery.qtip.js"></script>
    <script type="text/javascript" src="./js/layer.js"></script>
    <script type="text/javascript" src="./js/jquery.form.js"></script>
    <script type="text/javascript" src="./js/ypfunction.js"></script>
    <script type="text/javascript" src="./js/sendtask.js" charset="UTF-8"></script>
    
</head>

<script type="text/javascript">

</script>

<body class="rwdt_bg">
<div id="body">
 <jsp:include page="/page/header.jsp" /> 

<div class="h10"></div>


<div id="content">
  
    <form method="post" action="updatatask.action" onsubmit="return checkupdata()" enctype="multipart/form-data">
       
        <div id="body_main">
          
            <div id="product" class="div fabu">
                <div id="menu_div">
                    <a style="border-left:none;cursor: pointer" class="on">修改任务</a>
                 
                    <span style="width:580px;height: 52px;border-bottom: 2px dashed #57a0ff;display: block;float: left;"></span>
                </div>
                <div id="product_main" class="product_con">
                    <div class="pt">
						<span class="h40">
							<img class="h41" src="./img/blue.png" alt="">商品信息：
						</span>
						<span class="f_red">
							注：普通会员可发布流量任务和互助任务，高级会员可发布所有任务！
						</span>
                    </div>
                    <table class="fields_item" id="tableadd">
                        <tbody>
                        
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">任务编号</span></td><td class="tr">
								<input type="text" class="f_red" name="idtask" id="idtask" value="${task.taskId }" readonly/> </tr>
							</tr> 
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">所属分类</span></td>
								<td class="tr">
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
								</td>
							</tr>
							
							<tr>
								<td class="tl"><span class="title">商品主图</span></td>
								<td class="tr">
									<img id="picture1"  width="100px" height="80px" src="${task.taskGoodsPictur }">
									<input type="file" name="goodsfile" id="doc1" onclick="hidpicture1()">&nbsp;&nbsp;
									<span onclick="javascript:setImagePreview1();" class="jt">[预览]</span>&nbsp;&nbsp; 
									<span class="f_red" id="dzhutu"></span><span class="note">方便刷手查找，图片格式JPG，300KB以下。</span>
								</td>
								<style>
									#localImag {display:none; width:350px; height: 300px; border: 1px solid #D4CD49; position:fixed;left:50%;top:25% }
								</style>
								<div id="localImag" onMouseOut="hideDiv()"><img id="preview"  style="display: block;"></div>
							</tr>
							<tr>
								<td class="tl"><span class="title">要求图片</span></td>
								<td class="tr">
									<img id="picture2"  width="100px" height="80px" src="${task.taskRequirePictur }">	
									<input type="file" name="requirePictur" id="doc2" onclick="hidpicture2()" >&nbsp;&nbsp;
									<span onclick="javascript:setImagePreview2();" class="jt">[预览]</span>&nbsp;&nbsp; 
									<span class="f_red" id="dzhutu"></span><span class="note">方便刷手查找，图片格式JPG，300KB以下。</span>
								</td>
								<style>
									#localImag {display:none; width:550px; height: 500px; border: 1px solid #D4CD49; position:fixed;left:20%;top:20% }
								</style>
								<div id="localImag" onMouseOut="hideDiv()"><img id="preview"  style="display: block;"></div>
							</tr>
							
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">商品价格</span></td>
								<td class="tr"><input type="text" name="shopprice" id="shopprice" size="30" onBlur="calculation()"  value="${task.taskGoodsPrice }"/> 
								</td></tr>
							</tr> 
							
						
							
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">搜索词</span></td><td class="tr">
								<input type="text" name="searchword" id="searchword" size="30" onBlur="calculation()" value="${task.taskSearchword }"/> <span class="f_red" id="dprice"></span></td></tr>
							</tr> 
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">选择手机单/电脑单</span></td>
								<td class="tr">
									<select id="taskClass" name="taskClass" onchange="calculation()">
										<s:if test="#task.taskPhoneOrPc==1">
											 <option value="1" selected>电脑单</option>
									 		 <option value="2" >手机单</option>
										</s:if>
										
										<s:if test="#task.taskPhoneOrPc==2">
											 <option value="1" >电脑单</option>
									 		 <option value="2" selected>手机单</option>
										</s:if>
									 
									</select>
									<span id="dcatid" class="f_red"></span>
								</td>
							</tr>
							
							<tr>
								<td class="tl"><span class="f_red">*</span> <span class="title">信誉要求</span></td>
								<td class="tr">
									<select name="taskrank" id="taskrank">
									<s:if test="#task.taskCredit==1">
										  <option value="1" selected>一心</option>
										  <option value="2" >两心</option>
										  <option value="3" >三心</option>
										  <option value="4" >四心</option>
										  <option value="5" >五心</option>
										  <option value="6" >砖石</option>
									</s:if>
									<s:if test="#task.taskCredit==2">
										  <option value="1" >一心</option>
										  <option value="2" selected>两心</option>
										  <option value="3" >三心</option>
										  <option value="4" >四心</option>
										  <option value="5" >五心</option>
										  <option value="6" >砖石</option>
									</s:if>
									<s:if test="#task.taskCredit==3">
										  <option value="1" >一心</option>
										  <option value="2" >两心</option>
										  <option value="3" selected>三心</option>
										  <option value="4" >四心</option>
										  <option value="5" >五心</option>
										  <option value="6" >砖石</option>
									</s:if>
									<s:if test="#task.taskCredit==4">
										  <option value="1" >一心</option>
										  <option value="2" >两心</option>
										  <option value="3" >三心</option>
										  <option value="4" selected>四心</option>
										  <option value="5" >五心</option>
										  <option value="6" >砖石</option>
									</s:if>
									<s:if test="#task.taskCredit==5">
										  <option value="1" >一心</option>
										  <option value="2" >两心</option>
										  <option value="3" >三心</option>
										  <option value="4" >四心</option>
										  <option value="5" selected>五心</option>
										  <option value="6" >砖石</option>
									</s:if>
									<s:if test="#task.taskCredit==6">
										  <option value="1" >一心</option>
										  <option value="2" >两心</option>
										  <option value="3" >三心</option>
										  <option value="4" >四心</option>
										  <option value="5" >五心</option>
										  <option value="6" selected>砖石</option>
									</s:if>
									 
									</select>
									<span id="dcatid" class="f_red"></span>
								</td>
							</tr>	
							
						
							</tr>
							
						
						
							<tr>
								<td class="tl"></td>
								<td class="tr"> <div>${message }</div></td>
							</tr>				
						</tbody>
                    </table>
                    <div style="clear:both;"></div>
                </div>
            </div>
          	
         
             <div class="sudiv">
                <input id="btnCilentAdd" class="button abtn7" value="立即修改" type="submit">
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