<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Profile page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/profileStyle.css" media="all">
	</head>
	<body>
		${errorProfile}
		<h3>Профиль: ${foundRecord.fullName}</h3>
		<div id="photo">Photo</div>
		<div id="info">
			<p><span>Ф.И.О. </span>${foundRecord.fullName}</p>
			<p><span>Адрес </span>${foundRecord.address}</p>
			<p><span>Телефон </span>${foundRecord.phoneNumber}</p>
			<p><span>Дата создания </span>${foundRecord.creationDate}</p>
			<p><span>Mail </span>${foundRecord.mail}</p>
			<p><span>Дата рождения </span>${foundRecord.birthDate}</p>
		</div>
	</body>
</html>
