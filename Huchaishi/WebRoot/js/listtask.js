var tasktype = null;
var pcorphone = null;
var taskcredit = null;
var taskgold = null;



//查找每个任务所需的消耗
function searchtask(tasktype1,pcorphone1,taskcredit1,taskgold1){
	
	$("#divon1 a").click(function(){
	    $("#divon1 a").removeClass("nov");
	    //上一行，把虽有的p中清楚 on
	    $(this).addClass("nov");
	    //对当前的点击的p元素，添加class
	});
	
	$("#cheak1 a").click(function(){
	    $("#cheak1 a").removeClass("acolor");
	    //上一行，把虽有的p中清楚 on
	    $(this).addClass("acolor");
	    //对当前的点击的p元素，添加class
	});
	
	$("#cheak2 a").click(function(){
	    $("#cheak2 a").removeClass("acolor");
	    //上一行，把虽有的p中清楚 on
	    $(this).addClass("acolor");
	    //对当前的点击的p元素，添加class
	});
	
	$("#cheak3 a").click(function(){
	    $("#cheak3 a").removeClass("acolor");
	    //上一行，把虽有的p中清楚 on
	    $(this).addClass("acolor");
	    //对当前的点击的p元素，添加class
	});
	
	if(tasktype1!=''){
		tasktype = tasktype1;
	}
	if(pcorphone1!=''){
		pcorphone = pcorphone1;
	}
	if(taskcredit1!=''){
		taskcredit = taskcredit1;
	}
	if(taskgold1!=''){
		taskgold = taskgold1;
	}
	
	if(pcorphone1=='all'){
		pcorphone = null;
	}
	if(taskcredit1=='all'){
		taskcredit = null;
	}
	if(taskgold1=='all'){
		taskgold = null;
	}
	
	dataString = "tasktype="+tasktype+"&pcorphone="+pcorphone+"&taskcredit="+taskcredit+"&taskgold="+taskgold;

	
	$.ajax({  
		type: 'post',  
		url: 'listTask.action',
		data: dataString ,
		dataType : 'json',
		error: function(XmlHttpRequest,textStatus,errorThrown){  
			
		},  
		
		success: function(data){ 
			
			var table1 = $("#tasktable");
			table1.empty();
			var json = eval("("+data+")");
			 $.each(json, function (index) {  
                 //循环获取数据    
                 var id = json[index].taskId;
                 var member = json[index].taskSendUser;
                 var pcorphone = json[index].taskPhoneOrPc;
                 if(pcorphone==1){
                	 pcorphone=4;
                 }else{
                	 pcorphone=9;
                 }
                 var taskGoodsPrice = json[index].taskGoodsPrice;
                 var taskReward = json[index].taskReward;
                 var taskCredit = json[index].taskCredit;
                 var taskGoodsPictur = json[index].taskGoodsPictur;
                 var taskRequirePictur = json[index].taskRequirePictur;
                 var tasktype = json[index].taskType;
                 var isprice = json[index].taskIsmprice;
                 var payWay = json[index].payWay;
                 var istop = json[index].taskIstop;
                 
                 var userlevel = document.getElementById("userlevel").value;
                
                 if(tasktype == 1 ){
                	 tasktype ='淘宝任务';
                 }
                 if(tasktype == 2 ){
                	 tasktype ='流量任务';
                 }
                 if(tasktype == 3 ){
                	 tasktype ='互助销量';
                 }
                 if(tasktype == 4 ){
                	 tasktype ='互助流量';
                 }
                 var htmlString = "<tr class='rwdt_list'>"+
					                 "<td>"+
					                     "<div class='c4'>"+
					                         "<div class='c41'>"+
					                             "<span class='c42'>任务编号："+id
					                              +"</span>"+
					                         "</div>"+
					                         "<table>"+
					                             "<tbody>"+
					                             	"<tr>"+
					                                     "<td>"+
					                                         "<img style='vertical-align:middle' src='./img/taskType_"+pcorphone+".jpg' class='c46' data-hasqtip='11'  title=''>"+
					                                     "</td>"+
					                                     "<td class='mid'>"+
					                                         "<ul>"+
					                                             "<li class='fbr'>"+
					                                                  "会员：<span class='f_red'>"+member+"</span>"+
					                                             "</li>"+
					                                             "<li class='rwjg' data-hasqtip='12' oldtitle='任务的下单金额' >"+
					                                                  "任务金额：<span class='f_red'>"+taskGoodsPrice+"</span> 元"+
					                                             "</li>"+
					                                            "<li class='rwjg' data-hasqtip='13' >"
																		;
                 											if(tasktype=='淘宝任务' || tasktype=='流量任务'){
                 												htmlString= htmlString+ "悬赏佣金：<span class='f_red'>"+taskReward+"</span> 元";
                 											}else{
                 												
                 											}
                 											htmlString= htmlString+ "</li>"+
					                                            "<li class='rwjg' data-hasqtip='13' >"+
																	"任务类型：<span class='f_red'>"+tasktype+"</span>"+
																"</li>"+
																"<li class='rwjg' data-hasqtip='13' oldtitle='完成任务后，您能获得的任务奖励' >"+
																		"信誉要求：<span class="+"xin"+taskCredit+"></span>"+
					                                             "</li>"+
                
					                                            
					                                         "</ul>"+
					                                         "<ul class='piccon'>"+
					                                            "<li><a href='#' rel='"+taskGoodsPictur+"' class='preview' title='' ><img  onmouseover='imagePreview()' src='"+taskGoodsPictur+"' alt='商品略缩图' width='100' height='75'></a></li>"+
					                                            "<li><a href='#' rel='"+taskRequirePictur+"' class='preview' title=''><img onmouseover='imagePreview()' src='"+taskRequirePictur+"' alt='任务略缩图' width='100' height='75'></a></li>";
            	 if(isprice == 1){
                	 htmlString = htmlString + "<li class='rwjg' data-hasqtip='13' oldtitle='完成任务后，您能获得的任务奖励' >"+
						"<em class='ired' data-hasqtip='34' aria-describedby='qtip-34'>审核</em>"+
						  "</li>";
                 }
            	 if(istop==1){
            		 htmlString = htmlString + "<li class='rwjg' data-hasqtip='13' oldtitle='完成任务后，您能获得的任务奖励' >"+
						"<em class='ired' data-hasqtip='34' aria-describedby='qtip-34'>置顶</em>"+
						  "</li>";
                 }
                
            	 if(tasktype=='淘宝任务'){
            		 if(payWay == 1){
                		 htmlString = htmlString + "<li class='rwjg' data-hasqtip='13' oldtitle='完成任务后，您能获得的任务奖励' >"+
    						"<em class='ired' data-hasqtip='34' aria-describedby='qtip-34'>远程付款</em>"+
    						  "</li>";
                	 }else{
                		 htmlString = htmlString + "<li class='rwjg' data-hasqtip='13' oldtitle='完成任务后，您能获得的任务奖励' >"+
    						"<em class='ired' data-hasqtip='34' aria-describedby='qtip-34'>平台押款</em>"+
    						  "</li>";
                	 }
            	 }
            	 
            	 
            	if(tasktype=='淘宝任务'){
            		 htmlString = htmlString + "</ul>"+
                     "</td>"+
                          "<td id='taskbutton"+id+"' align='center' class='right'>"+
                          "<a  class='qrw_btn button border-blue' href='javascript:void(0);' onclick='checkuser2("+userlevel+","+id+")'>抢此任务</a>"+
                          "</td>"+
                          "</tr>"+
                          "</tbody>"+
                          " </table>"+
                          "<div id='taskInfo"+id+"' class='c41'></div>"+
                          "</div>"+
                          "</td>"+
                          "</tr>";
            	}else if(tasktype=='流量任务'){
            		 htmlString = htmlString + "</ul>"+
                     "</td>"+
                          "<td id='taskbutton"+id+"'  align='center' class='right'>"+
                          "<a class='qrw_btn button border-blue' href='javascript:void(0);' onclick='checkuser1("+userlevel+","+id+")'>抢此任务</a>"+
                          "</td>"+
                          "</tr>"+
                          "</tbody>"+
                          " </table>"+
                          "<div id='taskInfo"+id+"' class='c41'></div>"+
                          "</div>"+
                          "</td>"+
                          "</tr>";
            	}else{
            		
            		htmlString = htmlString + "</ul>"+
                    "</td>"+
                         "<td id='taskbutton"+id+"'  align='center' class='right'>"+
                             "<a class='qrw_btn button border-blue' href='javascript:void(0);' onclick='checkuser1("+userlevel+","+id+")'>查看任务</a>"+
                         "</td>"+
                         "</tr>"+
                         "</tbody>"+
                         " </table>"+
                         "<div id='taskInfo"+id+"' class='c41'></div>"+
                         "</div>"+
                         "</td>"+
                         "</tr>";
            	}
            	
                 table1.append(htmlString);
             });  
		}         
	  });
}



