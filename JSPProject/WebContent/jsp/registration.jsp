<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Registration page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/registrationStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/libs/jquery-2.2.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/reg.js"></script>
}

</script>
		</script>
	</head>
	<body>
		<div id="registrationForm" class="box">
			<form action="actionController" method="POST" name="RegistrationForm" onSubmit="validForm(this); return false">
				<input type="hidden" name="command" value="registration">
				<p class="reg">Регистрация</p>
				<p><input type="text" name="login" value="" required placeholder="Логин" /></p>
				<p id="loginError" class="errors"></p>
				<p><input type="password" name="password" value="" required placeholder="Пароль"/>  </p>
				<p><input type="password" name="confirmedPassword" value="" required placeholder="Подтверждение пароля"/></p>
				<p id="passwordsError" class="errors"></p>
				<p class="errors">${errorLoginPassMessage }</p>
				<p class="errors">${wrongAction }</p>
				<p class="errors">${nullPage }</p>
				<p><input id="sendButton" type="submit" value="Зарегистрироваться"> </p>
			</form>
		</div>
	</body>
</html>