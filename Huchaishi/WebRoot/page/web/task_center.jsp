<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0045)# -->
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
<link rel="stylesheet" type="text/css" href="./css/jquery.qtip.css">
<script type="text/javascript" src="./js/jquery.qtip.js"></script>
<script type="text/javascript" src="./js/layer.js"></script>
<link rel="stylesheet" href="./css/layer.css"
	id="layui_layer_skinlayercss">
<script type="text/javascript" src="./js/jquery.form.js"></script>
<script type="text/javascript" src="./js/ypfunction.js"></script>
<script type="text/javascript" src="./js/toptask.js"></script>
</head>
<body class="rwdt_bg" onload="gotaskcenter.action">
	<jsp:include page="/page/header.jsp" />

	<!--logo开始-->
	<div id="header" class="clean"></div>
	<div class="hyzx">
		<div class="hyzx_dh">
			<div class="hyzx_nav">
				<div class="menu persoanal_0">
				<div class="personal"><a id="edit" href="goUserManage.action">会员管理</a></div>  
					<div class="personal">
						<a id="edit" href="updatauser.action">修改资料</a>
					</div>
					<div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
					<div class="personal">
						<a id="gold" href="gogoldbuy">金币管理</a>
					</div>
					<div class="personal">
						<a id="taobaohao1" href="goboundstore" >绑定管理</a>
					</div>
					<div class="personal">
						<a id="taskcenter" href="gotaskcenter.action" class="on">任务管理</a>
					</div>
					<div class="personal">
						<a id="p-center" href="listcenter.action">个人中心</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="ypcon">
		<div class="menu">
			<table cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
				<td class="tab"><a id="m1" href="gotaskcenter.action" class="sb0"><span>发布的任务</span></a></td>
                <td class="tab"><a id="m4" href="gotaskcenterget.action" ><span>接受的任务</span></a></td>
                
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<script>
        $(function () {
            $(".thumb").qtip({
                style: {
                    classes: 'qtip-bootstrap'
                },
                content: function () {
                    return '<img src="' + $(this).attr("thumb") + '"/>';
                },
                position: {
                    my: 'top left',
                    at: 'bottom left',
                    adjust: {
                        x: 350, y: 0
                    }
                }
            });
        });
    </script>
		<div class="ls">
			<table cellpadding="0" cellspacing="0" class="tb">
				<tbody>
					<tr>
						<th>任务编号</th>
						<th>任务状态</th>
						<th>接收人</th>
						<th>任务小号</th>
						<th>查看任务</th>
						<th width="100">操作</th>
					</tr>
					<s:iterator value="#tasklist" var ="task">
					<s:if test = "#task.taskShowSend==0">
						<tr onmouseover="this.className=&#39;on&#39;;"	onmouseout="this.className=&#39;&#39;;" align="center" class="">

						<td height="30">
							${task.taskId }
						</td>
						<td>
							<span style="color:#00F">
								<s:if test="#task.taskStauts==1">
									任务发布
									<s:if test="#task.taskIstop==1"><span class="f_red">（已置顶）</span></s:if>
								</s:if>
								<s:if test="#task.taskStauts==2">
									任务进行中
								</s:if>
								<s:if test="#task.taskStauts==3">
									待审核
								</s:if>
								<s:if test="#task.taskStauts==4">
									完成任务
								</s:if>
								<s:if test="#task.taskStauts==5">
									任务结束
								</s:if>
								<s:if test="#task.taskStauts==6">
									任务已过期
								</s:if>
								
							</span>
						</td>
						<td class="px11 f_gray">
							${task.taskGetUser }
						</td>
						<td class="px11 f_gray">
							${task.taskUserAccount }
						</td>
						<td class="px11 f_gray">
							<a href="showtask.action?taskid=${task.taskId }">查看任务</a>
						</td>
						<td>
							<div id="operate">		
								<s:if test="#task.taskIsmprice==1 && #task.taskStauts==3">
									<a id="operate" href="taskreviewd.action?taskid=${task.taskId }&taskstatus=2"
										onclick="if(!confirm(&#39;确定要通过审核吗？此操作将不可撤销&#39;)) return false;">通过审核 </a>
								</s:if>
								
								<s:if test="#task.taskStauts == 4 ">
									<a href="taskreviewd.action?taskid=${task.taskId }&taskstatus=5"
									onclick="if(!confirm(&#39;确定要确认完成任务吗？此操作将不可撤销&#39;)) return false;">确认任务完成</a>
								</s:if>
								
								<s:if test="#task.taskStauts == 5 ">
									
									<a href="deltasksendrecord.action?taskid=${task.taskId }"
									onclick="if(!confirm(&#39;确定要确认删除记录吗？此操作将不可撤销&#39;)) return false;" >删除记录</a>
								</s:if>
								
								<s:if test="#task.taskType == 3 || #task.taskType ==4 ">
									<s:if test="#task.taskStauts==1 && #task.taskIstop==0">
										<a href="javascript:void(0);" onclick=" if(confirm(&#39;顶置扣除任务币，确定要顶置任务吗？&#39;)) cheakistop(${task.taskId },<s:property value="#session.taskgold"/>) ">置顶任务</a>
									</s:if>
									<s:if test="#task.taskStauts!=6">
										<a href="goupdatatask.action?taskId=${task.taskId }">修改任务</a>
									</s:if>
									
								</s:if>
								
								<s:if test="#task.taskStauts != 4  && #task.taskStauts != 5 && #task.taskStauts != 2">
									<a href="deltask.action?taskid=${task.taskId }"
									onclick="if(!confirm(&#39;确定要删除任务吗？此操作将不可撤销&#39;)) return false;" style="color: red">删除任务</a>
								</s:if>
								
								
								
								
							</div>
							
						
						</td>
					</tr>
					</s:if>
					
					
					</s:iterator>
				    
				  	
									
					
					
				</tbody>
			</table>
		</div>
		
		<div id="page" class="pages"></div>
	</div>
	<script>
    $(function () {
        set_nav("taobaohao", "on");
        /**/
        set_nav("m2", "sb0");
        /**/
    });
</script>
	<div style="clear:both;"></div>
	<jsp:include page="/page/footer.jsp" />
	</div>
	<jsp:include page="/page/imtalk.jsp" />

	<div id="qtip-1" class="qtip qtip-default qtip-bootstrap qtip-pos-tl"
		tracking="false" role="alert" aria-live="polite" aria-atomic="false"
		aria-describedby="qtip-1-content" aria-hidden="true" data-qtip-id="1"
		style="z-index: 15001;">
		<div class="qtip-content" id="qtip-1-content" aria-atomic="true">禁用后，在发任务时将不会显示此账号</div>
	</div>
</body>
</html>