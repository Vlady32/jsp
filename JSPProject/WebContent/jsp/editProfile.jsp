<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Profile page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/editProfileStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/editProfile.js"></script>
		<style type="text/css">
			#sendRecordEdited input{
    			width: 80%;
    			height: 37px;
    			padding-left: 10px;
    			padding-right: 150px;
    			margin-bottom: 0px; 
    			font-size: 16px; 
    			border-top: 1px solid #e1e8ec;
    			border-right: 1px solid #eef2f5;
    			border-bottom: 1px solid #eef2f5;
    			border-left: 1px solid #e1e8ec;
    			border-radius: 4px;
			}
			#sendRecordEdited input[type="file"]{
				border: none;
			}
			#photo{
				float: left;
				margin-right: 20px;
			}

			#info{
				float: left;
				margin-left: 50px;
			}

			#changeRecord{
    			cursor: pointer;
    			color: #185e87;
    			border-width: 1px;
    			border-style: solid;
    			border-radius: 4px;
    			padding-left: 51px;
    			font-size: 18px;
    			text-shadow: 1px 1px 0 #c3e9f8;
    			background-color: #94dffc;
    			text-align: center;
			}

			#changeRecord:hover{
   				background-color: #5ecef9;
			}
		</style>
	</head>
	<body>
		${errorProfile}
		<c:if test="${empty resultAddition}">
			<h3>Профиль: ${foundRecord.fullName}</h3>
			<div id="photo">
				<c:if test="${not empty foundRecord.pathFile}">
					<img  src="data:image/jpg;base64,${foundRecord.getBase64Code()}" alt="${foundRecord.fullName}" width="200px" height="250px"/>
				</c:if>
				<c:if test="${empty foundRecord.pathFile}">
					<img  src="${pageContext.request.contextPath}/files/no_picture.jpg" alt="${foundRecord.fullName}" width="200px" height="250px"/>
				</c:if>
			</div>
		</c:if>
		<div id="info">
			<h3>${resultAddition}</h3>
			<form class="${empty resultAddition ? 'show' : 'hide'}" id="sendRecordEdited" method="post" action="actionController">
				<input type="hidden" name="item" value="${foundRecord.item}">
				<p>Ф.И.О. <br> <input type="text" name="fullName" value="${foundRecord.fullName}" required/><br>  <span id="errorFullName" class="errors">${checkingFullName}</span></p>
				<p>Адрес: <br> <input type="text" name="address" value="${foundRecord.address}" required/> <br> <span id="errorAddress" class="errors">${checkingAddress}</span></p>
				<p>Телефонный номер: <br> <input type="text" name="phoneNumber" value="${foundRecord.phoneNumber}" required/> <br> <span id="errorPhoneNumber" class="errors">${checkingPhoneNumber}</span></p>
				<p>Mail: <br> <input type="text" name="mail" value="${foundRecord.mail}" /><br>  <span id="errorMail" class="errors">${checkingMail}</span></p>
				<p>Дата рождения: <br> <input type="date" id="birthDate" name="birthDate" value="${foundRecord.birthDate}" required/></p>
				<p>Фото: <br> <input type="file" id="photoFile" name="file" accept="image/jpeg,image/png,image/gif" value=""/> <br> <span id="errorFile" class="errors"></span></p>
				<input type="submit" id="changeRecord" value="Изменить запись">
			</form>
		</div>
	</body>
</html>
