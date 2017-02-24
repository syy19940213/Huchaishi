document.write("<script language=javascript src='./js/jquery-1.8.3.min.js'></script>");
var countdown = 60;
var cheackNum = null;

function sendCheackNum(obj) {
	if (checkPhone()) {
		var phone = document.getElementById('PhoneNum').value;
		cheackNum = creatCheackNum();
//		console.log("cheackNum"+ cheackNum);
		 //向后台发送处理数据
		$.ajax({
			type: 'post',  
			url: "sendcheackNum.action",
			data: "mobile="+phone+"&sendcheackNum="+cheackNum,
			dataType : 'json',
			error: function(XmlHttpRequest,textStatus,errorThrown){  
				
			},  
			
			success: function(data){ 
				console.log(data);
				var json = eval("("+data+")");
				var success = json.success;
				var error = json.error;
				console.log(success);
				if(typeof(success) == "undefined"){
					alert("该手机号已经被注册");
					return false;
				}

			}
		}) ;
			
	
		
		
//		$(function(){
//			 $.ajax({
//				 type: "POST",
//		            contentType: "application/json",
//		            url: "sendcheackNum.action",
//		            data: "{mobile:13343437048,cheackNum:1234}",
//		            datatype: 'json',
//		            cache: false,
//		            success: function(json) {
//		            	console.log(json);
//		            }
//			 });  
//		})
		
		countDown(obj);
	} else {
		alert("手机号码有误,请重填");
		return false;
	}	
	
}

//检查数据是否输入完整
function checkForm(){
	var username=document.getElementById("UserName").value; 
	var Password=document.getElementById("Password").value; 
	var vPassword=document.getElementById("vPassword").value; 
	var UserQq=document.getElementById("UserQq").value; 
	var RealName=document.getElementById("RealName").value; 
	var Email=document.getElementById("Email").value; 
	
	var a=document.getElementById("cheacNum").value; 
	if(username==''){
		alert("用户名为空！");
		return false;
	}else if(Password=='' || vPassword=='' ){
		alert("请输入正确密码！");
		return false;
	}else if(UserQq==''){
		alert("QQ为空！");
		return false;
	}else 	if(cheackNum==null){
		alert("请输入正确的验证码");
		return false;
	}else if(a!=cheackNum){
		alert("请输入正确的验证码");
		return false;
	}else if(RealName==''){
		alert("请输入真实姓名");
		return false;
	}else if(checkCardID()){
		return false;
	}else if(Email==''){
		alert("请输入正确email");
		return false;
	}else{
		console.log("验证成功");
		return true;
	}

	
	
	
}

var flag = function checkCardID()
{
	var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	if(reg.test(document.getElementById("CardId").value))	{
		document.getElementById("sapn_cardID").innerHTML="<img src='./img/right.png'/>";
		return true;
	}
	else{
		document.getElementById("sapn_cardID").innerHTML="请输入正确的身份证号";
		return false;
		}
}

function cheakCheackNum(){
	if(document.getElementById("cheacNum").value == cheackNum){
		document.getElementById("span_cheachNum").innerHTML="<img src='./img/right.png'/>";
		return true;
	}else{
		document.getElementById("span_cheachNum").innerHTML="<img src='./img/yesno.gif'>&nbsp;请输入正确的验证码";
		return false;
	}
}

function cheakPassword(){
	var pwd=document.getElementById("Password").value; 
	var reChinese=/[\u0391-\uFFE5]+/;
	var b_chinese=reChinese.test(pwd);
	var reSpace=/\s+/;
	var b_space=reSpace.test(pwd);
	console.log("cheack Password")
	//-------长度测试
	if(pwd.length<6){
		document.getElementById("span_Password").innerHTML="密码长度不能小于6";
	   flag4[1]=0;
	   check_data4();
	}
	//-------合法性检测:不能包含汉字
	else if(b_chinese){
		document.getElementById("span_Password").innerHTML="密码不能包含中文";
	   flag4[1]=0;
	   check_data4();
	}
	//-------合法性检测:不能包含空格
	else if(b_space){
		document.getElementById("span_Password").innerHTML="密码不能包含空格";
	   flag4[1]=0;
	   check_data4();
	}
	//-------合法时显示密码强度
	else{
	   //定义对应的消息提示
	   var num=getResult(pwd);
	   var msg=new Array("<img src='./img/bad.gif'/> 密码强度差","<img src='./img/comm.gif'/> 密码强度一般","<img src='./img/good.gif'/> 密码强度强壮");
	   document.getElementById("span_Password").innerHTML=msg[num];
	   if(pwd!=""){
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
	    	document.getElementById("span_vPassword").innerHTML="<img src='./img/right.png'/>";
	     flag4[2]=1;
	     check_data4();
	    }
	    else{
	    	document.getElementById("span_vPassword").innerHTML="密码不一致";
	     flag4[2]=0;
	     check_data4();
	    }
	   }
	}





//倒计时
function  countDown(obj){
	
	if (countdown == 0) {
		obj.removeAttribute("disabled");
		obj.value = "获取验证码";
		countdown = 60;
		return;
	} else {
		obj.setAttribute("disabled", true);
		obj.value = "重新发送(" + countdown + ")";
		countdown--;
	}
	setTimeout(function() {countDown(obj)}, 1000)
}

//生成随机验证码
function creatCheackNum(){
	code = "";  
	var codeLength = 4;//验证码的长度  
	var random = new Array(0,1,2,3,4,5,6,7,8,9);//随机数
	for(var i = 0; i < codeLength; i++) {//循环操作  
	    var index = Math.floor(Math.random()*10);//取得随机数的索引（0~35）  
	     code += random[index];//根据索引取得随机数加到code上  
	}  
	return code;
}

//验证手机号是否正确
function checkPhone() {
	var phone = document.getElementById('PhoneNum').value;
	if (!(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(phone))) {
		return false;
	} else {
		return true;
	}
}



