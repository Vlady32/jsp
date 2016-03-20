<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Error page</title>
	</head>
	<body>
		<p>Request from ${pageContext.errorData.requestURI}</p>
		<p>Servlet name or type: ${pageContext.errorData.servletName}</p>
		<p>Status code: ${pageContext.errorData.statusCode}</p>
		<p>Exception: ${pageContext.errorData.throwable}</p>
	</body>
</html>