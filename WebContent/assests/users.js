
$(document).ready(
		
 function(){
	 $('#sb').attr('disabled',true);
	 $("#bd").datepicker({changeYear:true,changeMonth:true, dateFormat:"yy-mm-dd"});

 $("#cup").keyup(
function(){
	if($("#up").val()==$("#cup").val())
		{
		$('#im').attr('src','icon/tick.png');	
		$('#sb').attr('disabled',false);
		}
	else
		{
		$('#im').attr('src','icon/cross.png');
		$('#sb').attr('disabled',true);
		}
	 
	
}	//function closed	 
 
 );//keyup closed

$("#uid").keyup(
		function(){
			$.getJSON("ChechUserID",{ajax:true,uid:$("#uid").val()},
					function(data){
				
				if(data.value==="This Id is Already Exist")
					$('#msg').html("<font color=red>"+data.value+"</font>");
				else
					$('#msg').html("<font color=green>This Id is OK...</font>");
			});
		});
$('#sbtn').click(
		function(){
			$.getJSON("ChangePasswordJSON",{ajax:true,op:$('#op').val(),up:$('#up').val()},
					function(data){alert("cp up");
				$('#result').html(data.value);
				
			});
					
		});

$('#pro_sbtn').click(
		function(){alert("cp up1");
			$.getJSON("UsersRegistrationSubmit",{ajax:true,uid:$('#uid').val(),fn:$('#fn').val(),ln:$('#ln').val(),bd:$('#bd').val()
				,ug:$('#ug').val(),em:$('#em').val(),up:$('#up').val()},
					function(data){alert(data.value); 
				$('#result').html(data.value);
				
			});
					
		});

 });

