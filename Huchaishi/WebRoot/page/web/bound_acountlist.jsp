<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=GBK">

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
</head>
<body class="rwdt_bg" onload="boundstorelist.action">
	<jsp:include page="/page/header.jsp" />

	<!--logo开始-->
<div id="header" class="clean">
      
    </div>
    <div class="hyzx">
    <div class="hyzx_dh">
        <div class="hyzx_nav">
            <div class="menu persoanal_0">
            <div class="personal"><a id="edit" href="goUserManage.action">会员管理</a></div>  
                <div class="personal"><a id="edit" href="updatauser.action">修改资料</a></div>                
               <div class="personal"><a id="gold" href="gotaskgoldrecord">任务币币管理</a></div>  
                <div class="personal"><a id="gold" href="gogoldbuy">金币管理</a></div>
                <div class="personal"><a id="taobaohao" href="goboundstore" class="on">绑定管理</a></div>
                <div class="personal"><a id="gold" href="gotaskcenter.action">任务管理</a></div>
				<div class="personal"><a id="p-center" href="listcenter.action" >个人中心</a></div>
            </div>
        </div>
    </div>
</div><div id="ypcon">
    <div class="menu">
        <table cellpadding="0" cellspacing="0">
            <tbody>
				<td class="tab"><a id="m3" href="goboundstore" ><span>绑定店铺</span></a></td>
                <td class="tab"><a id="m3" href="goboundaccount" ><span>绑定账号</span></a></td>
                <td class="tab"><a id="m3" href="boundstorelist.action"><span>店铺列表</span></a></td>
                <td class="tab"><a id="m1" href="boundacountlist.action" class="sb0"><span>账号列表</span></a></td>
            </tr>
        </tbody></table>
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

						<th>帐号</th>
						<th>信用</th>
						<th>审核状态</th>
						<th>图片</th>
						<th width="40">删除</th>
					</tr>
					
					<s:iterator value="#accountList" var ="account">
						<tr onmouseover="this.className=&#39;on&#39;;"
						onmouseout="this.className=&#39;&#39;;" align="center" class="">

						<td height="30">&nbsp;&nbsp;${account.boundAccount }</td>
						
						<td>
							<span style="color:#00F">
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
							</span>
						</td>
						
						<td height="30">
							<s:if test="#account.boundAccountstatus == 1">
									审核中
							</s:if>
							<s:if test="#account.boundAccountstatus == 2">
									审核通过
							</s:if>
						</td>
						<td class="px11 f_gray">
							<img src="${account.boundAccountpicture }"   width="100" height="70" alt="" />
						</td>
					
						<td><a href="delboundaccount.action?accoutid=${account.id }&accountuserid = ${account.userId }"
							onclick="if(!confirm(&#39;确定要删除吗？此操作将不可撤销&#39;)) return false;"><img
								width="16" height="16" src="./img/delete.png" alt=""
								data-hasqtip="3" oldtitle="删除" title=""> </a></td>
						</tr>
					</s:iterator>
					
					
				</tbody>
			</table>
		</div>
		<div class="limit">
			总共可添加 <span class="f_b f_red">5</span> 个&nbsp;&nbsp;&nbsp;
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