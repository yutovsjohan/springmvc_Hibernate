<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title><spring:message code="login.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center"><spring:message code="login.label" /></div>
		<div class="panel-body">
			<form class="form-horizontal" action="login" method="post">
				<div class="form-group">
					<label class="control-label col-sm-4" for="userName"><spring:message code="login.userName" /></label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="userName" name="userName" placeholder="<spring:message code="login.userName.plhd" />" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="pwd"><spring:message code="login.password" /></label>
					<div class="col-sm-5">
						<input type="password" class="form-control" id="pwd" name="password" placeholder="<spring:message code="login.password.plhd" />" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-5">
					<button type="submit" class="btn btn-primary"><spring:message code="login.btn" /></button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>