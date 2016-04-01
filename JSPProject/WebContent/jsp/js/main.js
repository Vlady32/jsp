$(document).ready(function(){
	
	function deleteClass() {
		$("nav a").removeClass("active");
	}
	
	$(".view").click(function() {
		deleteClass();
		$(this).addClass("active");
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
		deleteClass();
		$(this).addClass("active");
		sendAjax("add");
	});
	
	$("#edit").click(function() {
		deleteClass();
		$(this).addClass("active");
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
		deleteClass();
		$(this).addClass("active");
		sendAjax("delete")
	});
	
	$(".search").click(function() {
		deleteClass();
		$(this).addClass("active");
		sendAjax("search");
	});
	
	$("#control").click(function() {
		deleteClass();
		$(this).addClass("active");
		$.ajax({ 
			type: "POST",
			url: "actionController",
			data: {command: 'control', start: '0'},
			success: function(html){ 
				$("#workplace").html(html);
			}
		});
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