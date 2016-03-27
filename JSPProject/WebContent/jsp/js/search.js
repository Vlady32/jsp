$(document).ready(function(){
	
	$('#searchRecords').submit(function (e) {
		console.log($("select").val());
		e.preventDefault();
		var data = $(this).serialize();
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: data,
	        success: function(html){ 
	        	$("#workplace").html(html);
	        }
	    });
	})
	
	$(".items").click(function() {
		console.log($(this).attr("data-item"));
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: {command: 'profile', item: $(this).attr("data-item")},
	        success: function(html){ 
	        	$("#workplace").html(html);
	        }
	    });
	});

	$(".pages").click(function() {
		console.log("ajax pages");
		$.ajax({  
			type: "POST",
			url: "actionController", 
			data: {command: 'view', start: (($(this).text()-1)*30)},
			success: function(html){ 
				$("#workplace").html(html);
			}
		});
	});
	
})

