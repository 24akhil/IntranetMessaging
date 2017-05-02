$(document).ready(
		function(){
			if($('#stxt').val().length==0){
				$.getJSON("friendsJSON",{ajax:true,pat:$('#stxt').val()},
						function(data){
					var rs=' ';
					$.each(data,function(i,item){
						
						rs+='<br><a href=ComposeMessage?uid='+item.USERID+' target=mw>'+item.USERNAME+'</a>';
					});
					$('#result').html(rs);
				});
			}
			
			$('#stxt').keyup(function(){
				$.getJSON("friendsJSON",{ajax:true,pat:$('#stxt').val()},
						function(data){
					var rs=' ';
					$.each(data,function(i,item){
						
						rs+='<br><a href=ComposeMessage?uid='+item.USERID+' target=mw>'+item.USERNAME+'</a>';
					});
					$('#result').html(rs);
				});
				
			});
		});