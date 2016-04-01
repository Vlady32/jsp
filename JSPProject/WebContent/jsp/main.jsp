<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<head>
		<title>Main page</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainPageStyle.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/mainStyle.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/viewStyle.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/addStyle.css" media="all">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/libs/jquery-2.2.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
		<!-- Fancybox -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/libs/fancybox/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/libs/fancybox/jquery.fancybox.pack.js?v=2.1.5"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/libs/fancybox/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css" media="screen" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/libs/fancybox/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/libs/fancybox/helpers/jquery.fancybox-media.js?v=1.0.6"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/libs/fancybox/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css" media="screen" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/libs/fancybox/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>
	</head>
	<body>
		<header>
			<p id="firstP">Телефонный справочник</p>
			<p id="secondP">Приветствуем, ${user}</p>
			<p id="thirdP" class="logOut" onclick='document.getElementById("logOutForm").submit()'>Выход</p>
		</header>
		<div id="content">
			<nav>
			    <div class="${type.trim() eq 'user' ? 'show' : 'hide'}">
			    	<p><a class="itemsNav view">Просмотр справочника</a></p>		 
					<p><a class="itemsNav search">Поиск записей</a></p>
			    </div>
				<div class="${type.trim() eq 'admin' ? 'show' : 'hide'}">
					<p><a class="itemsNav view">Просмотр справочника</a></p>
					<p><a class="itemsNav" id="add">Добавление записей</a></p>
					<p><a class="itemsNav" id="edit">Редактирование записей</a></p>
					<p><a class="itemsNav search">Поиск записей</a></p>
					<p><a class="itemsNav" id="control">Управление списком пользователей</a></p>
				</div>
			</nav>
			<div id="workplace"></div>
			<div id="hfooter"></div>
		</div>
		<footer>
			<span>Телефонный справочник &#169; 2016</span>
		</footer>
		<form id="logOutForm" action="actionController" method="POST" style="display:none">
			<input type="hidden" name="command" value="logout">
		</form>
	</body>
</html>