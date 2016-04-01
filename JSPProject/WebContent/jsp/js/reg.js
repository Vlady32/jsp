$(document).ready(function(){
	$('input[name=login]').focus(function(){
		$("#loginError").text('');
	});
	$('input[name=password]').focus(function(){
		$("#passwordsError").text('');
	});
	$('input[name=confirmedPassword]').focus(function(){
		$("#passwordsError").text('');
	});
	 
})

function validForm(f) {
	var login = $('input[name=login]').val();
	var password = $('input[name=password]').val();
	var confirmPassword = $('input[name=confirmedPassword]').val();
	if(checkLogin(login) && checkPasswords(password, confirmPassword)) {
		f.submit();
	}
}

function checkLogin(login){
	var regExp = /^\w+$/;
		if(regExp.test(login)){
			return true;
		}else{
			$('input[name=login]').val('');
			$("#loginError").text("Login has to consist of letters, numbers, and underscores.");
			return false;
		}
}

function checkPasswords(password, confirmPassword){
	if(password != confirmPassword){
		$("#passwordsError").text("Password and confirmed password don't equal.");
			$('input[name=password]').val('');
			$('input[name=confirmedPassword]').val('');
			return false;
		}
	return true;
}	