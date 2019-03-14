<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/courses.js" />"></script>
<title><spring:message code="course.detail.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center"><spring:message code="course.detail.label"></spring:message></div>
		<div class="panel-body">			
			<form:form class="form-horizontal" action="./course" method="post" modelAttribute="course">
				<form:input path="id" type="hidden"/>
				<div class="form-group">
					<label class="control-label col-sm-4" for="fName">
					<spring:message code="course.detail.name"></spring:message>
					</label> 
					<div class="col-sm-6">
						<form:input path="courseName" type="text" class="form-control" id="fName" name="fName" placeholder="Course name" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<c:if test = "${mode == 'VIEW' }">
							<button disabled="disabled" type="submit" class="btn btn-primary">
								<spring:message code="course.detail.btn.save"></spring:message>
							</button>
						</c:if>
						<c:if test = "${mode != 'VIEW' }">
							<button type="submit" class="btn btn-primary">
								<spring:message code="course.detail.btn.save"></spring:message>
							</button>
						</c:if>
						<button type="button" onclick="getCourses()" class="btn btn-default">
							<spring:message code="course.detail.btn.cancel"></spring:message>
						</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>