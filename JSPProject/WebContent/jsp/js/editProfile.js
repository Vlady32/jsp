$(function(){
	$('#sendRecordEdited').submit(function(e){
		e.preventDefault();
		var fullName = $('input[name=fullName]').val();
		var address =  $('input[name=address]').val();
		var phoneNumber =  $('input[name=phoneNumber]').val();
		var photo = document.getElementById("photoFile");
		var mail = $('input[name=mail]').val();
		if(validateFile(photo) && checkFullName(fullName) && checkAddress(address) && checkPhoneNumber(phoneNumber) && checkMail(mail)){
			var m_method=$(this).attr('method');
			var m_action=$(this).attr('action');
			var formData = new FormData();
			formData.append("command", 'edit_bd_profile');
			formData.append("item", $('input[name=item]').val());
			formData.append("birthDate", $('#birthDate').val());
			formData.append("fullName", fullName);
			formData.append("phoneNumber", phoneNumber);
			formData.append("mail", mail);
			formData.append("address", address);
			formData.append("photo", document.getElementById("photoFile").files[0]);
			$.ajax({
				type: m_method,
				url: m_action,
				data: formData,
				contentType: 'multipart/form-data;charset=UTF-8',
				processData: false,
				contentType: false,
				success: function(result){
					//$("#workplace").html(result);
					$.fancybox(result, {
          				autoSize: true,
          				width: '700px',
          				height: '400px',
          				openEffect: 'none',
          				closeEffect: 'none'
        			});
				}
			});
		}
	});
});

$(document).ready(function(){
	$('input[name=fullName]').focus(function(){
		$("#errorFullName").text('');
	});
	$('input[name=address]').focus(function(){
		$("#errorAddress").text('');
	});
	$('input[name=phoneNumber]').focus(function(){
		$("#errorPhoneNumber").text('');
	});
	$('input[name=mail]').focus(function(){
		$("#errorMail").text('');
	});
})

function validateFile(fileInput) {
	  var fileObj, size;
	  if ( typeof ActiveXObject == "function" ) { // IE
	    fileObj = (new ActiveXObject("Scripting.FileSystemObject")).getFile(fileInput.value);
	  }else {
	    fileObj = fileInput.files[0];
	  }
	  if(fileObj == null){
		  return true;
	  }
	  size = fileObj.size;
	  if(size > 2 * 1024 * 1024){
	    fileInput.parentNode.innerHTML = fileInput.parentNode.innerHTML;
	    $("#errorFile").val("File size is exceeded. Allowed file size: 2 MB");
	    return false;
	  }
	  return true;
}

function checkFullName(fullName){
	var regExp = /^[ a-zA-Zа-яА-ЯёЁ]+$/;
	if(regExp.test(fullName)){
		return true;
	}else{
		$("#errorFullName").text("Full name has to consist of only letters and spaces");
		return false;
	}
}

function checkAddress(address){
	var regExp = /^[ \wа-яА-ЯёЁ.,-]+$/;
	if(regExp.test(address)){
		return true;
	}else{
		$("#errorAddress").text("Address has to consist of only letters, numbers and spaces");
		return false;
	}
}

function checkPhoneNumber(phone){
	var regExp = /^\+?\d+$/;
	if(regExp.test(phone)){
		return true;
	}else{
		$("#errorPhoneNumber").text("Telephone has to consist of only numbers and + at the beginning");
		
	}
}

function checkMail(mail){
	if(mail == null || mail == ""){
		return true;
	}
	var regExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(regExp.test(mail)){
		return true;
	}else{
		$("#errorMail").text("Wrong mail. Right mail: example@com.by");
		return false;
	}
}



