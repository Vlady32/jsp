$(document).ready(function(){

	$(".pages").click(function() {
		$.ajax({  
			type: "POST",
			url: "actionController", 
			data: {command: 'edit', start: (($(this).text()-1)*30)},
			success: function(html){ 
				$("#workplace").html(html);
			}
		});
	});
	
	
	$(".editIcon").click(function() {
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: {command: 'edit_profile', item: $(this).parent().attr("data-item")},
	        success: function(html){ 
//	        	$("#workplace").html(html);
	        	$.fancybox(html, {
          			autoSize: true,
          			openEffect: 'none',
          			closeEffect: 'none'
        		});
	        }
	    });
	})
	
	$(".removeIcon").click(function() {
			if (confirm("Вы действительно хотите удалить запись?")) {
				$.ajax({  
					type: "POST",
			        url: "actionController", 
			        data: {command: 'delete', item: $(this).parent().attr("data-item"), start: '0'},
			        success: function(html){ 
			        	$("#workplace").html(html);
			        }
			    });
			}
		})
	
	
	
	$("tr").mouseover(function() {
		$(".tools",this).show();
	});
	
	$("tr").mouseout(function() {
		$(".tools",this).hide();
	});
	
	setTimeout(function() {
		  $(".successView").remove();
		}, 5000);
	
})

