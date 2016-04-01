$(document).ready(function(){
	
	$('#searchRecords').submit(function (e) {
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
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: {command: 'profile', item: $(this).attr("data-item")},
	        success: function(html){ 
	        	//$("#workplace").html(html);
	        	$.fancybox(html, {
          			autoSize: true,
          			openEffect: 'none',
          			closeEffect: 'none'
        		});
	        }
	    });
	});
	
})

