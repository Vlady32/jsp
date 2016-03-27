<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Search page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/searchStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/search.js"></script>
	</head>
	<body>
		${errorDelete}
		<form id="searchRecords" method="post" action="actionController">
			<input type="hidden" name="command" value="search">
			<p>Введите ключевое слово: <input type="text" name="phraseSearch" value="${phraseSearch}"></p>
			<p>Выберите категорию поиска: 
				<select name="category">
					<option value="fullName">Ф.И.О.</option>
					<option value="address">Адрес</option>
					<option value="phoneNumber">Телефон</option>
					<option value="all">Везде</option>
				</select>
			</p>
			<p><input type="submit" value="Искать"></p>
		</form>
		${errorView}
		<table class="${empty errorView && listRecords.size() > 0 ? 'showTable' : 'hide'}">
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
	</body>
</html>
