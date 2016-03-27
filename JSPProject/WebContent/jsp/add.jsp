<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Main page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/addStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/add.js"></script>
	</head>
	<body>
	<div id="addPage">
		<h3>${resultAddition}</h3>
		<form class="${empty resultAddition ? 'show' : 'hide'}" id="sendRecord" method="post" action="actionController">
			<input type="hidden" name="command" value="add">
			<p>Ф.И.О. <input type="text" name="fullName" value="" required/></p>
			<p>Адрес: <input type="text" name="address" value="" required/></p>
			<p>Телефонный номер: <input type="text" name="phoneNumber" value="" required/></p>
			<p>Mail: <input type="text" name="mail" value="" /></p>
			<p>Дата рождения: <input type="date" name="birthDate" value=""/></p>
			<p>Фото: <input type="file" name="file" value=""/></p>
			<input type="submit"  id="go" value="Добавить запись">
		</form>
	</div>
	</body>
</html>