<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Profile page</title>
		<style type="text/css">
			#photoProfile{
				float: left;
				margin-right: 20px;
			}

			#infoProfile{
				margin-left: 20px;
				float: left;
				width: 300px;
			}
			span{
				font-weight: bold;
			}
			h3{
				text-align: center;
			}
		</style>
	</head>
	<body>
		${errorProfile}
		<h3>Профиль: ${foundRecord.fullName}</h3>
		<div id="photoProfile">
			<c:if test="${not empty foundRecord.pathFile}">
				<img  src="data:image/jpg;base64,${foundRecord.getBase64Code()}" alt="${foundRecord.fullName}" width="200px" height="250px"/>
			</c:if>
			<c:if test="${empty foundRecord.pathFile}">
				<img  src="${pageContext.request.contextPath}/files/no_picture.jpg" alt="${foundRecord.fullName}" width="200px" height="250px"/>
			</c:if>
		</div>
		<div id="infoProfile">
			<p><span>Ф.И.О. </span>${foundRecord.fullName}</p>
			<p><span>Адрес: </span>${foundRecord.address}</p>
			<p><span>Телефон: </span>${foundRecord.phoneNumber}</p>
			<p><span>Дата создания: </span>${foundRecord.creationDate}</p>
			<p><span>Mail: </span>${foundRecord.mail}</p>
			<p><span>Дата рождения: </span>${foundRecord.birthDate}</p>
		</div>
	</body>
</html>
