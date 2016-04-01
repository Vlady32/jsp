$(document).ready(function(){

	$(".pages").click(function() {
		$.ajax({  
			type: "POST",
			url: "actionController", 
			data: {command: 'control', start: (($(this).text()-1)*30)},
			success: function(html){ 
				$("#workplace").html(html);
			}
		});
	});
	
	$(".removeIcon").click(function() {
			if (confirm("Вы действительно хотите удалить запись?")) {
				$.ajax({  
					type: "POST",
			        url: "actionController", 
			        data: {command: 'delete_user', userName: $(this).parent().attr("data-user"), start: '0'},
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

