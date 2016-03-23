$(document).ready(function(){
	
	var currentPage = 1;
	
	function getCurrentPage() {
		return currentPage;
	}
	
	$("#logOut").click(function() {
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: {command: 'logout'},
	        success: function(html){ 
	        	window.location.href = "jsp/login.jsp"; 
	        }
	    });
	});
	
	$(".view").click(function() {
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: {command: 'view', start: '0'},
	        success: function(html){ 
	        	$("#workplace").html(html);
	        }
	    });
	});
	
	$(".pages").click(function() {
		console.log(function () {
			if (currentPage != $(this).text()){
				currentPage = $(this).text();
			}
		});
		$.ajax({  
			type: "POST",
	        url: "actionController", 
	        data: {command: 'view', start: (($(this).text()-1)*30)},
	        success: function(html){ 
	        	$("#workplace").html(html);
	        }
	    });
	});
	
	$("#add").click(function() {
		sendAjax("add");
	});
	
	$("#edit").click(function() {
		sendAjax("edit");
	});
	
	$("#delete").click(function() {
		sendAjax("delete")
	});
	
	$(".search").click(function() {
		sendAjax("search");
	});
	
	$("#control").click(function() {
		sendAjax("control")
	});
	
});

function sendAjax(parameterPath) {
	$.ajax({  
		type: "POST",
        url: "redirectController", 
        data: {path: parameterPath},
        success: function(html){  
            $("#workplace").html(html);  
        }  
    });
}