<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Control page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/controlStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/control.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/libs/fonts-awesome/font-awesome.min.css" media="all">
	</head>
	<body>
		${errorView}
		<h3 class="successView">${successView}</h3>
		<table class="${empty errorView ? 'showTable' : 'hide'}">
			<caption>Пользователи</caption>
			<tr>
				<th>№ п/п</th>
				<th>Имя пользователя</th>
				<th>Тип</th>
			</tr>
			<c:forEach var="el" items="${listUsers}" varStatus="status">
				<tr>
					<td><c:out value="${status.count + currentPosition}"/></td>
					<td><c:out value="${el.userName}"/></td>
					<td><c:out value="${el.type}"/></td>
					<td data-user="${el.userName}" class="withoutBorder tools hide"><i class="fa fa-times removeIcon"></i></td>
				</tr>	
			</c:forEach>
		</table>
		<div id="navPages">
			<c:forEach var="pages" begin="1" end="${qualityPages}">
				<a class="${ ((currentPosition+30)/30) == pages*1.0 ? '' : 'links'} pages">${pages}</a>
			</c:forEach>
		</div>
	</body>
</html>
