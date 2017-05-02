$(document).ready(
		
 function(){
	 
		 $.getJSON("SearchMessageJSON",{ajax:true,mid:$('#mid').val()},
					function(data){
			 var htm="<table width=50%>";
			 
				htm+="<tr><td><b><i>User Id:</i></b></td><td><input type=text name=uid value='"+data[0].USERID+"' readonly=true size=70></td></tr>";
				htm+="<tr><td><b><i>To:</i></b></td><td><input type=text name=uto value='"+data[0].USERID_TO+"' size=70></td></tr>";
				 htm+="<tr><td><b><i>Date/Time:</i></b></td><td><input type=text name=dt size=70 value='"+data[0].MSGDATETIME+"'></td></tr>";
				htm+="<tr><td><b><i>Subject:</i></b></td><td><input type=text name=sub value='"+data[0].SUBJECT+"' size=70></td></tr>";
				htm+="<table><br>";
				htm+="<b><i>Your Message..</i></b><br>";
				htm+="<textarea rows=10 cols=100 name=msg>"+data[0].MESSAGES+"</textarea><br><br><br>";
			    $('#result').html(htm);
			   
			

		 });
		 
 });