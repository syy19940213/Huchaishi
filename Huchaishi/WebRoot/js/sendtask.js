$(function(){
	    $("#tasktypeselect").change(function(){
	           if($(this).val()!=1){
	           		 $("#taobaotask").hide();
	           		 $("#taobaopayway").hide();
	           }else{
	           	     $("#taobaotask").show();
	           	     $("#taobaopayway").show();
	           }
	          calculation();
			
	    });
	
	});

$(function(){    
    $("#ss").attr("style","background-color:white;border:1px solid #999;border-right:none; width:108px;");        
    $(".li").click(function(){ 
    	$(".li").attr("style","none");  // ie下面不识别style="" 整了好久才整出来 等于none就可以 了
    	$(this).attr("style","background-color:white;border:1px solid #999;border-right:none; width:108px;");
    });
});


//确认是否有权限
function cheakSelect(userlevel){
	var type= document.getElementById("tasktypeselect").value;
	console.log(type == 2);
	console.log(userlevel == 0);
	if(type == 1 && userlevel != 2){
		alert("非本站高级会员，无权限操作！请申请高级会员！");
		window.location.href="goUserManage.action"; 
	}
	
}


/**
 * 通过taskid查找任务信息 并显示
 * @param id
 */
function showtask(obj,id,accountid){
	var account = $(obj).text();
	
	console.log("account:"+account);
	console.log("id:"+id);
	document.getElementById("model").style.display="none";
	var dataString = "taskId="+id;
	$.ajax({  
		type: 'post',  
		url: 'findTaskById.action',
		data: dataString ,
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			
		},  
		
		success: function(data){ 
			
			var json = eval("("+data+")");
			
			var task = json.task;
			var user = json.user;
			
			console.log(task);
			console.log(user);
			
			
			var divname = "#taskInfo"+id;
			var table1 = $(divname);
			table1.empty();
			var html = "<div style='margin-left: 125px;'>" +
					"<span>接手：<span class='f_red'>"+account+"</span></span>"+
					"<span style='margin-left: 20px;'>店铺名称：<span class='f_red'>"+task.taskShopName+"</span></span>"+
					"<span style='margin-left: 20px;'>商家QQ：<span class='f_red'>"+user.userQq+"</span></span>"+
					"</div>";
			table1.append(html);
		}
	});
	
	var name = "#taskbutton"+id;
	console.log("name:"+name);
	var button = $(name);
	button.empty();
	
	button.append("<a  class='qrw_btn button border-blue' href='javascript:void(0);' onclick='gettask("+accountid+","+id+")'>接受任务</a>");
}

/**
 * 接受任务
 */
function gettask(accountid,id){
	var dataString = "taskId="+id+"&accountId="+accountid;
	
	$.ajax({  
		type: 'post',  
		url: 'recivertask.action',
		data: dataString ,
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			
		},  
		
		success: function(data){ 
			
			var json = eval("("+data+")");
			var flag = json.flag;
			var message = json.message;
			console.log("flag:"+flag);
			console.log("message:"+message);
			if(flag == "true"){
				alert("接任务成功！");
				window.location.href="gotaskcenterget.action"; 
			}else{
				alert(message);
			}
		}
	});
}


/**
 * 选择小号
 * @param userlevel
 * @param id
 */
function chooseAccount(id){
	console.log(id);
	$.ajax({  
		type: 'post',  
		url: 'findAccount.action',
		data: dataString ,
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			
		},  
		
		success: function(data){ 
			var json = eval("("+data+")");
			console.log(json);
			var html = "";
			$.each(json, function (index) {  
				var accountid = json[index].id;
				var account = json[index].boundAccount;
				console.log(account);
				html += "<a onclick='showtask(this,"+id+","+accountid+")' class='accurl' value='"+account+"'><em class='iyellow'>"+account+"</em><span class='xin0'></span></a>";
			});
			var xiaohao = $("#xiaohao");
			xiaohao.empty();
			xiaohao.append(html);
		}
	});
	letDivCenter('#model');
}
	
function checkuser1(userlevel,id){

	console.log(userlevel == 0);
	if(userlevel == 0){
		alert("非本站会员，无权限操作！请申请会员！");
		window.location.href="goUserManage.action"; 
	}else{
		
		chooseAccount(id);
	}
}

function checkuser2(userlevel,id){

	console.log(userlevel != 2);
	if(userlevel != 2){
		alert("非本站高级会员，无权限操作！请申请会员！");
		window.location.href="goUserManage.action"; 
	}else{
		chooseAccount(id);
	}
}



function checkuser(userlevel){
	console.log(userlevel == 0);
	if(userlevel == 0){
		alert("非本站会员，无权限操作！请申请会员！");
		window.location.href="goUserManage.action"; 
	}else{
		chooseAccount(id);
	}
}


function hidpicture1(){
	$("#picture1").hide();
}
function hidpicture2(){
	$("#picture2").hide();
}

function hideDiv(){
	$("#localImag").hide();
}

function showDiv(){
	$("#localImag").show();
}

function hideDiv1(){
	$("#localImag1").hide();
}

function showDiv1(){
	$("#localImag1").show();
}


//图片预览
function setImagePreview1(avalue) {
		var docObj=document.getElementById("doc1");
		$("#localImag").show();
		var imgObjPreview=document.getElementById("preview");
		if(docObj.files &&docObj.files[0])
		{
		//����£�ֱ����img����
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '550px';
		imgObjPreview.style.height = '500px'; 
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		 
		//���7���ϰ汾�����������getAsDataURL()��ʽ��ȡ����Ҫһ�·�ʽ
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		}
		else
		{
		//IE�£�ʹ���˾�
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		var localImagId = document.getElementById("localImag");
		//�������ó�ʼ��С
		localImagId.style.width = "550px";
		localImagId.style.height = "500px";
		//ͼƬ�쳣�Ĳ�׽����ֹ�û��޸ĺ�׺��α��ͼƬ
		try{
		localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
		localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		}
		catch(e)
		{
	
		return false;
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
		}
		
		return true;
}

//图片预览
function setImagePreview2(avalue) {
		var docObj=document.getElementById("doc2");
		$("#localImag").show();
		var imgObjPreview=document.getElementById("preview");
		if(docObj.files &&docObj.files[0])
		{
		//����£�ֱ����img����
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '550px';
		imgObjPreview.style.height = '500px'; 
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		 
		//���7���ϰ汾�����������getAsDataURL()��ʽ��ȡ����Ҫһ�·�ʽ
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		}
		else
		{
		//IE�£�ʹ���˾�
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		var localImagId = document.getElementById("localImag");
		//�������ó�ʼ��С
		localImagId.style.width = "550px";
		localImagId.style.height = "500px";
		//ͼƬ�쳣�Ĳ�׽����ֹ�û��޸ĺ�׺��α��ͼƬ
		try{
		localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
		localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		}
		catch(e)
		{
		alert("���ϴ���ͼƬ��ʽ����ȷ��������ѡ��!");
		return false;
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
		}
		
		return true;
}

//全局变量
var liuliangtask=null;
var huzhuxiaoliang=null;
var huzhuliuliang=null;

//查找每个任务所需的消耗
function searchConsume(){
	$.ajax({  
		type: 'post',  
		url: 'searchConsume.action',
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			alert("数据查找失败");  
		},  
		success: function(data){ 
			
			var json = eval("("+data+")");
			for(var o in json){  
				
				if(o==2){
					liuliangtask=json[o];
				}else if(o==3){
					huzhuxiaoliang=json[o];
				}else if(o==4){
					huzhuliuliang  = json[o];
				}
			}  
		}         
	  });
}

//计算所需要的金币
function calculation(){
	var gold=0;
	
	searchConsume();
	var price= document.getElementById("shopprice").value;
	var type= document.getElementById("tasktypeselect").value;
	var taskClass= document.getElementById("taskClass").value;
	var taskNum = document.getElementById("taskNum").value;
	var payWay = -1;
	 var paycheack = document.getElementsByName("payWay");
	 for(var i=0;i<paycheack.length;i++){
	  if(paycheack[i].checked==true){
	   payWay=i;
	  }
	 }
	
	
	console.log("payWay"+ payWay);

	if(type==1){
		if(0<price && price<=50){
			gold=4;
		}else if(50<price && price<=150){
			gold=5;
		}else if(150<price && price<=350){
			gold=6;
		}else if(350<price && price<=550){
			gold=7;
		}else if(550<price && price<=750){
			gold=8;
		}else if(750<price && price<=850){
			gold=9;
		}else if(850<price && price<=1050){
			gold=10;
		}else if(1050<price && price<=1250){
			gold=12;
		}else if(1250<price && price<=1450){
			gold=14;
		}else if(1450<price && price<=1650){
			gold=16;
		}else if(1650<price && price<=1850){
			gold=18;
		}else{
			gold=20;
		}
		if(taskClass==2){
			gold=gold+1;
		}
		gold.toFixed(2); 
		document.getElementById("baseNum").innerHTML="<input type='text' name='baseNum' id='baseNum'  readonly='true'"+" value='"+gold+"'/>&nbsp金币";
		console.log(payWay==0)
		if(payWay==0){
			gold = accAdd(gold,price);
		}
		
		if(taskNum!=null){
			gold=gold*taskNum;
		}
		
		console.log("gold"+gold);
		document.getElementById("goldNum").innerHTML="<input type='text' name='consume' id='consume'  readonly='true'"+" value='"+gold+"'/>&nbsp金币";
	}else if(type==2){
		gold = liuliangtask ;
		if(taskClass==2){
			gold= accAdd(gold,0.3);
		}
		if(taskNum!=null){
			gold=(gold*taskNum).toFixed(1);
		}
		console.log(gold);
		document.getElementById("goldNum").innerHTML="<input type='text' name='consume' id='consume'  readonly='true'"+" value='"+gold+"'/>&nbsp金币";
	}else if(type==3){
		gold = huzhuxiaoliang;
		if(taskNum!=null){
			gold=accMul(gold,taskNum);
		}
		gold.toFixed(2); 
		document.getElementById("goldNum").innerHTML="<input type='text' name='consume' id='consume'  readonly='true'"+" value='"+gold+"'/>&nbsp发布币";
	}else if(type==4){
		gold = huzhuliuliang;
		if(taskNum!=null){
			gold=accMul(gold,taskNum);
		}
		document.getElementById("goldNum").innerHTML="<input type='text' name='consume' id='consume'  readonly='true'"+" value='"+gold+"'/>&nbsp发布币";
	}
	
} 

/**
 ** 加法函数，用来得到精确的加法结果
 ** 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
 ** 调用：accAdd(arg1,arg2)
 ** 返回值：arg1加上arg2的精确结果
 **/
function accAdd(arg1, arg2) {
    var r1, r2, m, c;
    try {
        r1 = arg1.toString().split(".")[1].length;
    }
    catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    }
    catch (e) {
        r2 = 0;
    }
    c = Math.abs(r1 - r2);
    m = Math.pow(10, Math.max(r1, r2));
    if (c > 0) {
        var cm = Math.pow(10, c);
        if (r1 > r2) {
            arg1 = Number(arg1.toString().replace(".", ""));
            arg2 = Number(arg2.toString().replace(".", "")) * cm;
        } else {
            arg1 = Number(arg1.toString().replace(".", "")) * cm;
            arg2 = Number(arg2.toString().replace(".", ""));
        }
    } else {
        arg1 = Number(arg1.toString().replace(".", ""));
        arg2 = Number(arg2.toString().replace(".", ""));
    }
    return (arg1 + arg2) / m;
}

//给Number类型增加一个add方法，调用起来更加方便。
Number.prototype.add = function (arg) {
    return accAdd(arg, this);
};

/**
 ** 乘法函数，用来得到精确的乘法结果
 ** 说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
 ** 调用：accMul(arg1,arg2)
 ** 返回值：arg1乘以 arg2的精确结果
 **/
function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try {
        m += s1.split(".")[1].length;
    }
    catch (e) {
    }
    try {
        m += s2.split(".")[1].length;
    }
    catch (e) {
    }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}

// 给Number类型增加一个mul方法，调用起来更加方便。
Number.prototype.mul = function (arg) {
    return accMul(arg, this);
};

function checkupdata(){
	
	if(document.getElementById("doc1").value == ''  && $("#picture1").is(":hidden")){
		alert("请选择商品主图");
		return false;
	}else if(document.getElementById("doc2").value == '' && $("#picture2").is(":hidden")){
		alert("请选择要求图片");
		return false;
	}else if(document.getElementById("taskClass").value == ''){
		alert("请选择任务平台");
		return false;
	}else if(document.getElementById("searchword").value == ''){
		alert("请填写搜索词");
		return false;
	}else if(document.getElementById("taskrank").value == ''){
		alert("请选择信誉要求");
		return false;
	}else{
		console.log("验证成功");
		return true;
	}
}


function checkdata(){
	
	if(document.getElementById("tasktypeselect").value == ''){
		alert("请选择任务分类");
		return false;
	}else if(document.getElementById("tname").value == ''){
		alert("请选择绑定店铺");
		return false;
	}else if(document.getElementById("doc1").value == ''){
		alert("请选择商品主图");
		return false;
	}else if(document.getElementById("doc2").value == ''){
		alert("请选择要求图片");
		return false;
	}else if(document.getElementById("shopprice").value == ''){
		alert("请输入商品价格");
		return false;
	}else if(document.getElementById("taskClass").value == ''){
		alert("请选择任务平台");
		return false;
	}else if(document.getElementById("taskrank").value == ''){
		alert("请选择信誉要求");
		return false;
	}else if(document.getElementById("taskNum").value == ''){
		alert("请输入任务数量");
		return false;
	}else if(document.getElementById("sendtime").value == ''){
		alert("请输入间隔时间");
		return false;
	}else{
		console.log("验证成功");
		return true;
	}
}
 
 