<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Login page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/loginStyle.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainStyle.css" media="all">
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/actionController" method="POST" name="LoginForm">
			<input type="hidden" name="command" value="login">
			<p>Sign in to PhoneBook</p>
			<p>Login: <input type="text" name="login" value="" required/>  </p>
			<p>Password: <input type="password" name="password" value="" required/>  </p>
			<p class="errors">${errorLoginPassMessage }</p>
			<p class="errors">${wrongAction }</p>
			<p class="errors">${nullPage }</p>
			<p><input id="sendButton" type="submit" value="Log in"> </p>
		</form>
		<form id="redirectForm" action="redirectController" method="POST" style="display:none">
			<input type="hidden" name="path" value="registration">
		</form>
		<p>New? <a class="links" onclick='document.getElementById("redirectForm").submit()'>Create account</a></p>
	</body>
</html>