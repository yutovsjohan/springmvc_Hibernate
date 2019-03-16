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
	src="<c:url value="/resources/js/students.js" />"></script>
<title>Student Detail</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">Student Detail</div>
		<div class="panel-body">			
			<form:form class="form-horizontal" action="./student" method="post" modelAttribute="student">
				<form:input path="id" type="hidden"/>
				<div class="form-group">
					<label class="control-label col-sm-4" for="fName">
					firstname
					</label> 
					<div class="col-sm-6">
						<form:input path="firstName" type="text" class="form-control" id="fName" name="fName" placeholder="firstname" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="lName">
					lastname
					</label> 
					<div class="col-sm-6">
						<form:input path="lastName" type="text" class="form-control" id="lName" name="lName" placeholder="lastname" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="age">
					age
					</label> 
					<div class="col-sm-6">
						<form:input path="age" type="number" class="form-control" id="age" name="age" placeholder="age" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<c:if test = "${mode == 'VIEW' }">
							<button disabled="disabled" type="submit" class="btn btn-primary">
								SAVE
							</button>
						</c:if>
						<c:if test = "${mode != 'VIEW' }">
							<button type="submit" class="btn btn-primary">
								SAVE
							</button>
						</c:if>
						<button type="button" onclick="getStudents()" class="btn btn-default">
							CANCEL
						</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>