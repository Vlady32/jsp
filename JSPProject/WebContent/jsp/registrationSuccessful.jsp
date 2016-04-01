<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Index page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/regSuccess.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/regSuccess.js"></script>
	</head>
	<body>
	<div id="success" class="box">
		<h2>Вы успешно зарегистрировались!</h2>
		<form id="loginForm" action="redirectController" method="POST" style="display:none">
			<input type="hidden" name="path" value="login">
		</form>
		<p class="redirect">Сейчас вы будете перенаправлены на страницу входа. Если этого не произошло автоматически, пожалуйста, нажмите <a class="links" onclick='document.getElementById("loginForm").submit()'> перейти</a>.</p>
		</body>
	</div>
</html>