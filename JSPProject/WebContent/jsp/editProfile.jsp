<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Profile page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/editProfileStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/editProfile.js"></script>
	</head>
	<body>
		${errorProfile}
		<h3>Профиль: ${foundRecord.fullName}</h3>
		<div id="photo">Photo</div>
		<div id="info">
			<h3>${resultAddition}</h3>
			<form class="${empty resultAddition ? 'show' : 'hide'}" id="sendRecordEdited" method="post" action="actionController">
				<input type="hidden" name="command" value="edit_bd_profile">
				<input type="hidden" name="item" value="${foundRecord.item}">
				<p>Ф.И.О. <input type="text" name="fullName" value="${foundRecord.fullName}" required/></p>
				<p>Адрес: <input type="text" name="address" value="${foundRecord.address}" required/></p>
				<p>Телефонный номер: <input type="text" name="phoneNumber" value="${foundRecord.phoneNumber}" required/></p>
				<p>Mail: <input type="text" name="mail" value="${foundRecord.mail}" /></p>
				<p>Дата рождения: <input type="date" name="birthDate" value="${foundRecord.birthDate}"/></p>
				<p>Фото: <input type="file" name="file" value=""/></p>
				<input type="submit" value="Изменить запись">
			</form>
		</div>
	</body>
</html>
