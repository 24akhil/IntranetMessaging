$('document').ready(function(){
	
	$.getJSON('FetchStateJSON',{ajax:true},
			function(data){
		    $('#state').empty();
		    $('#state').append($('<option>').text('-Select-'));
		    $.each(data,function(i,item){
		    
		  $('#state').append($('<option>').text(item.STATE).attr('value',item.STATEID));	
		    	
		    	
		    });
		});
	$('#state').change(function(){
		
		$.getJSON('FetchCitiesJSON',{ajax:true,stateid:$('#state').val()},
				function(data){
			    $('#city').empty();
			    $('#city').append($('<option>').text('-Select-'));
			    $.each(data,function(i,item){
			    
			  $('#city').append($('<option>').text(item.CITY).attr('value',item.CITY));	
			    	
			    	
			    });
			});
		 
	});
	
	
	$('#sbtn').click(function(){
		$.getJSON('ProfileSubmitJSON',{ajax:true,uid:$('#uid').val(),add:$('#add').val(),state:$('#state option:selected').text(),city:$('#city').val(),sts:$('#sts').val(),work:$('#work').val(),quali:$('#quali').val()},
				function(data){alert(data);
			     $('#result').html(data.value);
			    });
			 
	});
	
	
	
});