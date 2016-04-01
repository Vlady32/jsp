$(document).ready(function(){
	
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

	$(".pages").click(function() {
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

