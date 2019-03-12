<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.label" /></title>
</head>
<body>
	<h2><spring:message code="login.label" /></h2>
	<form action="login" method="post">
		<div>
			<input type="text" name="userName" size="20" />
		</div>
		<div>
			<input type="password" name="password" size="20" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
		Current Locale : ${pageContext.response.locale}
	</form>
</body>
</html>