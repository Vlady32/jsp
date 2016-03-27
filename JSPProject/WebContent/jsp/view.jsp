<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>View page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/viewStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/view.js"></script>
	</head>
	<body>
		<p class="error">${errorView}</p>
		<table class="${errorView.trim() eq 'Downloading data error' ? 'hide' : 'showTable'}">
		<caption>Телефонный справочник</caption>
			<tr>
				<th>№ п/п</th>
				<th>Ф.И.О.</th>
				<th>Адрес</th>
				<th>Номер телефона</th>
			</tr>
			<c:forEach var="el" items="${listRecords}" varStatus="status">
				<tr>
					<td class="links items" data-item="${el.item}"><c:out value="${status.count + currentPosition}"/></td>
					<td><c:out value="${el.fullName}"/></td>
					<td><c:out value="${el.address}"/></td>
					<td><c:out value="${el.phoneNumber}"/></td>
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