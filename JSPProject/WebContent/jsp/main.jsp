<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Main page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainStyle.css" media="all">
	</head>
	<body>
		<h3>Welcome, ${type} ${user}</h3>
		<form id="logoutForm" action="actionController" method="POST" style="display:none">
			<input type="hidden" name="command" value="logout">
		</form>
		<a class="links" onclick='document.getElementById("logoutForm").submit()'>Log out</a>
	</body>
</html>