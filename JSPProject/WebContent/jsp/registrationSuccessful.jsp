<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Index page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainStyle.css" media="all">
	</head>
	<body>
		<h3>You have successfully registered!</h3>
		<form id="loginForm" action="redirectController" method="POST" style="display:none">
			<input type="hidden" name="path" value="login">
		</form>
		<a class="links" onclick='document.getElementById("loginForm").submit()'>Log in</a>
	</body>
</html>