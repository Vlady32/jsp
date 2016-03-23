<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Main page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainStyle.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainPageStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-2.2.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
	</head>
	<body>
		<header>
			<h3 id="welcome">Welcome, ${type} ${user}</h3>
			<a class="links" id="logOut">Log out</a>
		</header>
		<hr id="afterHeader">
		<div id="content">
			<nav>
			    <div class="${type.trim() eq 'user' ? 'show' : 'hide'}">
			    	<p><a class="links view">Просмотр справочника</a></p>		 
					<p><a class="links search">Поиск записей</a></p>
			    </div>
				<div class="${type.trim() eq 'admin' ? 'show' : 'hide'}">
					<p><a class="links view">Просмотр справочника</a></p>
					<p><a class="links" id="add">Добавление записей</a></p>
					<p><a class="links" id="edit">Редактирование записей</a></p>
					<p><a class="links" id="delete">Удаление записей</a></p>
					<p><a class="links search">Поиск записей</a></p>
					<p><a class="links" id="control">Управление списком пользователей</a></p>
				</div>
			</nav>
			<div id="workplace">Workplace</div>
		</div>
		<hr id="afterContent">
		<footer>Footer</footer>
		<!--   <form id="sendForm" action="redirectController" method="POST" style="display:none">
			<input id="attrSend" type="hidden" name="path">
		</form> -->
	</body>
</html>