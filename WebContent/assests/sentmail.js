$(document).ready(
		
 function(){
	 if($('#stxt').val().length==0)
		 {
		 $.getJSON("SentMailJSON",{ajax:true,pat:$('#stxt').val()},
					function(data){
			var rs='<table width=100% cellspacing=3>';		 
			 $.each(data,function(i,item){
				 rs+='<tr><td><input type=checkbox name=msgid value='+item.MSGID+'</td>';
				 msg=item.MESSAGES;
				 if(msg.length>0)
					 {
					 msg=msg.substring(0,40)+'...';
					 }
				 rs+='<td>'+item.USERID_TO+'<td><b>'+item.SUBJECT+'</b>-<a href=SearchMessage?mid='+item.MSGID+'>'+msg+'</a></td>';
				 rs+='<td>'+item.MSGDATETIME+'<td></tr>';
	 				 });
			    rs+='</table>'
			    $('#result').html(rs);
						   });
		 
		 }
	 
	 
	 
	 
  $('#stxt').keyup(function(){	 
	 
	 $.getJSON("SentMailJSON",{ajax:true,pat:$('#stxt').val()},
				function(data){
		var rs='<table width=100% cellspacing=3>';		 
		 $.each(data,function(i,item){
			 rs+='<tr><td><input type=checkbox name=msgid id=msgid vlaue='+item.MSGID+'</td>';
			 msg=item.MESSAGES;
			 if(msg.length>0)
				 {
				 msg=msg.substring(0,40)+'...';
				 }
			 rs+='<td>'+item.USERID_TO+'<td><b>'+item.SUBJECT+'</b>-<a href=SearchMessage?mid='+item.MSGID+'>'+msg+'</a></td>';
			 rs+='<td>'+item.MSGDATETIME+'<td></tr>';
 				 });
		    rs+='</table>';
		    $('#result').html(rs);
					   }); 
  });
		 
 });