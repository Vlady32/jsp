$(document).ready(function(){
	
	function addClassLinks() {
		$("nav a").not(".links").addClass("links");
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
		addClassLinks();
		$(this).removeClass("links");
		console.log("ajax view");
		$.ajax({ 
			type: "POST",
			url: "actionController",
			data: {command: 'view', start: '0'},
			success: function(html){ 
				$("#workplace").html(html);
			}
		});
	});
	
	$("#add").click(function() {
		addClassLinks();
		$(this).removeClass("links");
		sendAjax("add");
	});
	
	$("#edit").click(function() {
		addClassLinks();
		$(this).removeClass("links");
		console.log("ajax edit");
		$.ajax({ 
			type: "POST",
			url: "actionController",
			data: {command: 'edit', start: '0'},
			success: function(html){ 
				$("#workplace").html(html);
			}
		});
	});
	
	$("#delete").click(function() {
		addClassLinks();
		$(this).removeClass("links");
		sendAjax("delete")
	});
	
	$(".search").click(function() {
		addClassLinks();
		$(this).removeClass("links");
		sendAjax("search");
	});
	
	$("#control").click(function() {
		addClassLinks();
		$(this).removeClass("links");
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