function cheakistop(taskid,taskgold){
	
	
	
	var dataString="taskId="+taskid+"&taskGold="+taskgold;
	$.ajax({  
		type: 'post',  
		url: 'cheakistop.action',
		data: dataString ,
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			
		},  
		success: function(data){ 
			var obj = eval('(' + data + ')');
			if(obj == 1){
				window.location.href="toptask.action?taskId="+taskid; 
			}else{
				alert(obj);
				window.location.href="goldchange.action"; 
			}
			
		}
	});
	
}