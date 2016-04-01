<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Add page</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/add.js"></script>
	</head>
	<body>
	<h3>${resultAddition}</h3>
	<div id="addPage" class="box ${empty resultAddition ? 'show' : 'hide'}">
		<form id="sendRecord" method="post" action="actionController">
			<h3>Добавление записи</h3>
			<p><input type="text" name="fullName" value="" required placeholder="Ф.И.О." /> <br><span id="errorFullName" class="errors">${checkingFullName}</span></p>
			<p><input type="text" name="address" value="" required placeholder="Адрес"/><br> <span id="errorAddress" class="errors">${checkingAddress}</span></p>
			<p><input type="text" name="phoneNumber" value="" required placeholder="Телефонный номер"/><br> <span id="errorPhoneNumber" class="errors">${checkingPhoneNumber}</span></p>
			<p><input type="text" name="mail" value="" placeholder="Mail" /> <br><span id="errorMail" class="errors">${checkingMail}</span></p>
			<p>Дата рождения:<br><input type="date" id="birthDate" name="birthDate" value="" required /></p>
			<p>Фото:<input type="file" name="photo" id="photoFile"  accept="image/jpeg,image/png,image/gif" value=""/> <br><span id="errorFile" class="errors">${checkingResult}</span></p>
			<input type="submit" id="addRecord" value="Добавить запись"> <span> ${maxSizeError}</span>
		</form>
	</div>
	</body>
</html>