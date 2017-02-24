<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)http://www.xyxshdq.com/member/register.php -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
    
    <title>互差事</title>
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/login-new.css">
    <script type="text/javascript" src="./js/config.js"></script>
    <script type="text/javascript" src="./js/common.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/jquery.qtip.css">
    <script type="text/javascript" src="./js/jquery.qtip.js"></script>
   
   <script type="text/javascript">     
    
    function init(){
    	alert("sadas");
        document.getElementById("username").focus();
    }
    function validate(userfield) {
        if (trim(userfield.value).length != 0) {
            var xmlHttpRequest = null;
            var url = "../UserNameIsExistServlet?UserName=" + userfield.value;
            var usermsg = document.getElementById("usermsg");
            if (window.XMLHttpRequest) {//表示当前浏览器不是IE
                xmlHttpRequest = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttpRequest.open("GET", url, true);//设置请求方式为GET，设置请求的URL，设置为异步提交
            xmlHttpRequest.onreadystatechange = function(){//将方法地址复制给onreadystatechange属性
                if(xmlHttpRequest.readyState == 4){//Ajax引擎状态为成功
                    if(xmlHttpRequest.status == 200){//HTTP协议状态为成功
                        if(trim(xmlHttpRequest.responseText) != ""){
                            usermsg.innerHTML = "<font color='red'>" + trim(xmlHttpRequest.responseText) + "</font>";
                            userfield.focus();
                        }else{
                            usermsg.innerHTML = "恭喜您，用户名可以使用。 ";
                        }
                    }else{
                        alert("请求失败，错误码=" + xmlHttp.status);
                    }
                }
            };
            xmlHttpRequest.send(null);//将设置信息发送到Ajax引擎
        }else{
            usermsg.innerHTML = "";
        }
    }
    
    
          $(function () {
            $("[title]").qtip({
                style: {classes: 'qtip-bootstrap'},
                position: {at: 'top right', adjust: {x: 20, y: 0}}
            });
        })
//new 
var $=function(tagName)
{
return document.getElementById(tagName);
}
//邮箱检测------------------------------------------------------------------------------4
function check_idea15(s)
{
var s = document.getElementById("Email").value;
var reEmail=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
var b_email=reEmail.test(s);
if(b_email)
{
   document.getElementById("span_15").innerHTML="<img src='./img/right.png'>";
}
else
{
    document.getElementById("span_15").innerHTML="<img src='./img/yesno.gif'>&nbsp;邮箱不可用";
}
}
//整数检测------------------------------------------------------------------------------4
function check_AboutSequence(s)
{
var reNum=/^[0-9]{1,20}$/;
var b_Num=reNum.test(s);
if(b_Num)
{
   $("span_Sequence").innerHTML="<img src='./img/right.png'>";
   flag1[1]=1;
}
else
{
   $("span_Sequence").innerHTML="<img src='./img/yesno.gif'>&nbsp;请填写整数";
   flag1[1]=0;
}
check_data1();
}
var flag8=[0,0,0];
function check_ProductName(s)
{
if(s=="")
{
   $("span_ProductName").innerHTML="<img src='./img/yesno.gif'>&nbsp;请输入产品名称";
   flag8[0]=0;
}
else
{
   $("span_ProductName").innerHTML="<img src='./img/right.png'>";
   flag8[0]=1;
}
check_data8();
}

function check_ProductID(s)
{
if(s=="")
{
   $("span_ProductID").innerHTML="<img src='./img/yesno.gif'>&nbsp;请输入产品编号";
   flag8[2]=0;
}
else
{
   $("span_ProductID").innerHTML="<img src='./img/right.png'>";
   flag8[2]=1;
}
check_data8();
}
//---------------------检查QQ不能为空
function check_QQ(s)
{
if(s=="")
{
   document.getElementById("span_QQ").innerHTML="请输入QQ";
   flag8[3]=0;
}else{
   document.getElementById("span_QQ").innerHTML="<img src='./img/right.png'>";
   flag8[3]=1;
}
check_data8();
}

function check_data8() //-------判断上面三项有没有填写，如果没有填写完整则“确定添加”按钮不可视
{
if(flag8[0]==1 && flag8[2]==1&& flag8[3]==1){
   $("Btn_OK").disabled=false;
}
else{
   $("Btn_OK").disabled=true;
}
}
//用户信息检测------------------------------------------------------------------------------4
var flag4=[0,0,0];
function check_Password(obj){
var pwd=$("Password").value;
var reChinese=/[\u0391-\uFFE5]+/;
var b_chinese=reChinese.test(pwd);
var reSpace=/\s+/;
var b_space=reSpace.test(pwd);
//-------长度测试
if(pwd.length<6){
   $("span_Password").innerHTML="密码长度不能小于6";
   flag4[1]=0;
   check_data4();
}
//-------合法性检测:不能包含汉字
else if(b_chinese){
   $("span_Password").innerHTML="密码不能包含中文";
   flag4[1]=0;
   check_data4();
}
//-------合法性检测:不能包含空格
else if(b_space){
   $("span_Password").innerHTML="密码不能包含空格";
   flag4[1]=0;
   check_data4();
}
//-------合法时显示密码强度
else{
   //定义对应的消息提示
   var num=getResult(pwd);
   var msg=new Array("<img src='./img/bad.gif'/> 密码强度差","<img src='./img/comm.gif'/> 密码强度一般","<img src='./img/good.gif'/> 密码强度强壮");
   $("span_Password").innerHTML=msg[num];
   if($("Password").value!=""){
    check_vPassword();
    }
   return flag4[1]=1;
   check_data4();
   }
}
//定义检测函数,返回0/1/2分别代表差/一般/强
function getResult(s){
   var ls =-1;
   if (s.match(/[a-z]/ig)){
    ls++;
   }
   if (s.match(/[0-9]/ig)){
    ls++;
   }
   if (s.match(/(.[^a-z0-9])/ig)){
    ls++;
   }
   return ls;
}
    //---------密码一致性检测 
function check_vPassword(){
	var pwd=document.getElementById("Password").value; 
	var check_pwd=document.getElementById("vPassword").value; 
 
   if(flag4[1]==1){
    if(pwd==check_pwd){
     $("span_vPassword").innerHTML="<img src='./img/right.png'/>";
     flag4[2]=1;
     check_data4();
    }
    else{
     $("span_vPassword").innerHTML="密码不一致";
     flag4[2]=0;
     check_data4();
    }
   }
}


    //---------用户名合法性检测
/* ======ajax.js 检测是否被注册过================BEGIN*/
// JavaScript Document
//--------------------------------------------------------------------
</script>

<script>
function $(e){return document.getElementById(e);}
function checkCardID()
{
var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
if(reg.test(document.getElementById("CardId").value))
{document.getElementById("sapn_cardID").innerHTML="<img src='./img/right.png'/>";}
else{
	document.getElementById("sapn_cardID").innerHTML="请输入正确的身份证号";
	}
}
</script>

</head>
<body>
<div class="wrapper" style="opacity: 1;">
    <table width="100%" style="height: 100%" align="center" background="./img/18.jpg">
        <tbody>
        <tr>
            <td align="center" valign="middle">
                <div id="dregister">
                    <div class="registerc">
                        <div class="registerz"></div>
                        <div id="content">
                           
                            <form action="register.action" id="myForm" method="post" onsubmit="return checkForm()" >
                                <div class="head">
                                    <a href="#"><span class="logo" style="background:url(./img/logo.png) no-repeat"></span></a>
                                    <span class="slogan"></span>
                                </div>
                                <script>
                                    $(function () {
                                        setInterval('$("#warning").animate({ opacity: "0" },800).animate({ opacity: "1" },800)', 1600);
                                    })
                                </script>
                                <ul id="reg_list">
                                    <li class="reg_title">账户信息</li>
                                    <li>
                                    	<s:if test="#message!=null">
                                    		${message }
                                    	</s:if>
                                    </li>                               
                                    	
                                    <li>
                                        <p class="title">会员名</p>
                                        <input id="UserName" maxlength="20" name="UserName" class="r_bk" type="text" onblur='validate(this);'>                                        
										 <span id='usermsg' class="zq">会员名应为小写字母(a-z)、数字(0-9)、下划线(_)、中划线(-)组合</span>
                                    </li>
                                    <li>
                                        <p class="title">登录密码</p>
                                        <input name="Password" class="r_bk" type='password' id='Password' size='40' onBlur="cheakPassword()"/>
                                        <span id='span_Password' class="zq">请填写密码(不能含中文且大于6个字符)</span>
                                    </li>
                                    <li>
                                        <p class="title">重复输入</p>
                                        <input name="vPassword" class="r_bk" type='password' id='vPassword' size='40' onBlur="cheakPassword()"/>
                                        <span id='span_vPassword' class="zq"></span>
                                    </li>
									<li>
                                        <p class="title">QQ号码</p>
                                         <input name="UserQq" type='text' class="r_bk" id='UserQq'  onBlur='check_QQ(this.value);'/>
										 <span id='span_QQ' class="zq"></span>
                                    </li>
                                    <li class="reg_title">联系方式</li>
                                    <li>
                                        <p class="title">真实姓名</p>
                                        <input id="RealName" onblur="validator(this);" name="RealName" class="r_bk" type="text" data-hasqtip="4" oldtitle="&lt;b style=&#39;color: #f00&#39;&gt;此项注册成功后不可修改！&lt;/b&gt;&lt;br&gt;请如实填写！" title="">
                                        <span></span>    
                                    </li>
                                    <li>
                                        <p class="title">身份证号</p>
                                        <input id="CardId" onBlur="checkCardID();" name="CardId" class="r_bk" type="text" data-hasqtip="4" oldtitle="&lt;b style=&#39;color: #f00&#39;&gt;此项注册成功后不可修改！&lt;/b&gt;&lt;br&gt;请如实填写！" title="">
                                        <span id="sapn_cardID" class="zq"></span>
                                    </li>
                                    <li>
                                        <p class="title">电子邮箱</p>
                                        <input onblur="check_idea15();" name="Email" class="r_bk" id="Email" type="text" data-hasqtip="5" oldtitle="系统设置了邮件验证注册，请确保当前的邮件地址真实有效" title="">
                                        <span id="span_15" class="zq"></span>
                                    </li>
                                    <li>
                                        <p class="title">手机号码</p>
                                        <input id="PhoneNum"  maxlength="11" name="PhoneNum" class="r_bk" type="text" data-hasqtip="6" oldtitle="号码可用于登录网站和接收本站短信" title="">
                                        <input type="button" class="button" id="btn"  value="获取验证码" onclick="sendCheackNum(this)" /> 
                                        <span></span>
                                    </li>
                                    <li>
                                        <p class="title">验证码</p>
                                        <input id="cheacNum" onblur="cheakCheackNum()" maxlength="11" name="cheacNum" class="r_bk" type="text" data-hasqtip="6"  title="请输入短信验证码">
                           			    <span id="span_cheachNum" class="zq"></span>
                                    </li>
                             
                                    <li>
                                        <p class="title">推荐人</p>
                                        
                                        	<input id="RecommendUser" maxlength="15" name="RecommendUser" class="r_bk" type="text" data-hasqtip="8" value="${recommenduser }"/>           
                                                            
                                    <li>										
                                        <input   name="submit"  class="reg_btn" id='reg_btn' value="" type="submit" style="margin-right: 20px; " />
                                        <table>
                                            <tbody><tr>
                                                <td><a href="logout.action">已有账号，登录 &gt;&gt;</a></td>
                                            </tr>
                                        </tbody></table>
                                    </li>
                                </ul>
                                <div style="clear: both"></div>
                            </form>
                        </div>
                    </div>
                    <div style="clear: both"></div>
                </div>
                
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script>
    $(function () {
        //用户协议
        $("#agreement").click(function () {
            $("#dregister").fadeOut(500, function () {
                $("#agreement_info").fadeIn(400);
            });
        });
        $("#agreement_info .d-ne").click(function () {
            $("#agreement_info").fadeOut(500, function () {
                $("#dregister").fadeIn(400);
            });
        })
    });
</script>
<script type="text/javascript" src="./js/guest.js"></script>
<script type="text/javascript">
    if (Dd('UserName').value == '') Dd('UserName').focus();
    var vid = '';
    var right = '<table class="zq"><tr><td><img src="./img/right.png"/></td></tr></table>';
    function validator(obj) {
        vid = $(obj).attr("id");
        makeRequest('moduleid=2&action=member&job=' + vid + '&value=' + Dd(vid).value, AJPath, '_validator');
    }
    function _validator() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            var con = xmlHttp.responseText ? xmlHttp.responseText : '<img src="./img/right.png" />';
            $("#" + vid).parent().find("span").html('<table class="zq"><tr><td>' + con + '</td></tr></table>');
        }
    }
    function right_msg(id) {
        $("#" + id).parent().find("span").html(right);
    }
    function err_msg(str, id) {
        $("#" + id).parent().find("span").html('<table class="zq"><tr><td>' + str + '</td></tr></table>');
    }
    function validate(type) {
        if (type == 'vPassword') {
            if (Dd('vPassword').value != Dd('Password').value) {
                err_msg('两次输入的密码不一致', type);
            } else {
                right_msg(type);
            }
        }
        if (type == 'truename') {
            if (Dd('truename').value.length < 2) {
                err_msg('请输入真实姓名', type);
            } else {
                right_msg('', type);
            }
        }
        if (type == 'telephone') {
            if (Dd('telephone').value.match(/^[0-9\-\(\)\+\.]{7,}$/)) {
                err_msg('', type);
            } else {
                right_msg('请输入商家电话', type);
            }
        }
    }
    function Df(ID) {
        Dd(ID).focus();
    }
    function check() {
        var f, p;
        f = 'username';
        if (Dd(f).value == '') {
            err_msg('请填写会员登录名', f);
            Df(f);
            return false;
        }
        f = 'idcard';
        if (Dd(f).value.length < 15) {
            err_msg('请输入有效的身份证号码', f);
            Df(f);
            return false;
        }
        f = 'password';
        if (Dd(f).value.length < 6) {
            err_msg('请填写会员登录密码', f);
            Df(f);
            return false;
        }
        f = 'cpassword';
        if (Dd(f).value == '') {
            err_msg('请重复输入密码', f);
            Df(f);
            return false;
        }
        if (Dd('password').value != Dd(f).value) {
            err_msg('两次输入的密码不一致', f);
            Df(f);
            return false;
        }
        f = 'truename';
        if (Dd(f).value == '') {
            err_msg('请填写真实姓名', f);
            Df(f);
            return false;
        }
        f = 'idcard';
        if (Dd(f).value == '') {
            err_msg('请填写真实姓名', f);
            Df(f);
            return false;
        }
        f = 'email';
        if (Dd(f).value.length < 6) {
            err_msg('请填写电子邮箱', f);
            Df(f);
            return false;
        }
        if (Dd('areaid_1').value == 0) {
            Dmsg('请选择所在地', 'areaid');
            return false;
        }
        /**/
        f = 'mobile';
        if (Dd(f).value.length < 11) {
            err_msg('请填写手机号码', f);
            Df(f);
            return false;
        }
        f = 'qq';
        if (Dd(f).value.length < 5) {
            err_msg('请填写QQ号码', f);
            Df(f);
            return false;
        }
        /**/
        /**/
        return true;
    }
</script>
 <script type="text/javascript" src="./js/register.js"></script>
<script>
    /*  淡入淡出  */
    $(function(){
        $(".wrapper").css("opacity",0).delay(400).animate({opacity:1},400);
    });
</script>

</body></html>