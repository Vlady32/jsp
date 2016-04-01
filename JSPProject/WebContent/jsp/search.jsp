<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Search page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/searchStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/search.js"></script>
		<style type="text/css">
			form{
				text-align: center;
				margin-top: 10px;
			}
			input, select{
				margin-left: 10px;
				width: 40%;
    			height: 37px;
    			padding-left: 10px;
    			margin-bottom: 5px; 
    			font-size: 16px; 
    			border-top: 1px solid #e1e8ec;
    			border-right: 1px solid #eef2f5;
    			border-bottom: 1px solid #eef2f5;
    			border-left: 1px solid #e1e8ec;
    			border-radius: 4px;
			}
			select{
				width: 20%;
			}
			input[type="submit"]{
				width: 20%;
				cursor: pointer;
				color: #185e87;
				border-width: 1px;
    			border-style: solid;
    			border-radius: 4px;
    			padding-left: 21px;
    			font-size: 18px;
    			padding-right: 21px;
				text-shadow: 1px 1px 0 #c3e9f8;
				background-color: #94dffc;
			}
			input[type="submit"]:hover{
				background-color: #5ecef9;
			}
		</style>
	</head>
	<body>
		${errorDelete}
		<form id="searchRecords" method="post" action="actionController">
			<input type="hidden" name="command" value="search">
			<input type="text" name="phraseSearch" placeholder="Ключевое слово" value="${phraseSearch}">
			<select name="category">
					<option value="fullName">Ф.И.О.</option>
					<option value="address">Адрес</option>
					<option value="phoneNumber">Телефон</option>
					<option value="all">Везде</option>
				</select>
			<input type="submit" value="Искать">
		</form>
		${errorView}
		<table class="${empty errorView && listRecords.size() > 0 ? 'showTable' : 'hide'}">
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
