<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Index page</title>
	</head>
	<body>
		<form action="actionController" method="POST" name="RegistrationForm">
			<input type="hidden" name="command" value="registration">
			<p>Sign up to PhoneBook</p>
			<p>Login: <input type="text" name="login" value=""/>  </p>
			<p>Password: <input type="password" name="password" value=""/>  </p>
			<p>Confirm password: <input type="password" name="confirmedPassword" value=""/>  </p>
			<p>${errorLoginPassMessage }</p>
			<p>${wrongAction }</p>
			<p>${nullPage }</p>
			<p><input id="sendButton" type="submit" value="Sign up"> </p>
		</form>
	</body>
</html>