
//用户申请操作ajax
function aboutUser(flag,userId){
	var applyDo;
	console.log(userId);
	if(flag==1){
		applyDo='申请会员';
	}else{
		applyDo='解除会员';
	}
	var dataString = "userId="+userId+"&applyDo="+applyDo;
	
	
	$.ajax({  
		type: 'post',  
		url: 'userApply.action',
		data: dataString ,
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			alert("申请提交失败！！");
		},  
		success: function(data){ 
			console.log(data);
			alert("申请提交成功，请勿重复提交！！");
		}
	  });  
}


