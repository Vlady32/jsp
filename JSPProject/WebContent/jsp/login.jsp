<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Login page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/loginStyle.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainStyle.css" media="all">
	</head>
	<body>
		<div id="loginForm" class="box">
			<form action="${pageContext.request.contextPath}/actionController" method="POST" name="LoginForm">
				<input type="hidden" name="command" value="login">
				<p class="in">Вход</p>
				<p><input type="text" name="login" value="" required placeholder="Логин" />  </p>
				<p><input type="password" name="password" value="" required placeholder="Пароль"/>  </p>
				<p class="errors">${errorLoginPassMessage }</p>
				<p class="errors">${wrongAction }</p>
				<p class="errors">${nullPage }</p>
				<p ><input id="sendButton" type="submit" value="Войти"> </p>
				<a class="registr" onclick='document.getElementById("redirectForm").submit()'>Регистрация</a>
			</form>
		</div>
		<form id="redirectForm" action="redirectController" method="POST" style="display:none">
			<input type="hidden" name="path" value="registration">
		</form>
	</body>
</html>