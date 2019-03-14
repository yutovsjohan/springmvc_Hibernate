<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<title><spring:message code="course.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div id="title" class="panel-heading h3 text-center">
			<spring:message code="course.header"></spring:message>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><spring:message code="course.table.id" /></th>
						<th><spring:message code="course.table.name" /></th>
						<th><spring:message code="course.table.action" /></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty courses}">
							<c:forEach items="${courses}" var="course">
								<tr>
									<td>${course.id}</td>
									<td>${course.courseName}</td>
									<td>
										<button class="btn btn-info"
											onclick="getCourse(${course.id}, 'VIEW');">
											<spring:message code="course.btn.view" />
										</button>
										<button class="btn btn-primary"
											onclick="getCourse(${course.id}, 'EDIT');">
											<spring:message code="course.btn.edit" />
										</button>
										<button class="btn btn-danger"
											onclick="deleteCourse(${course.id});">
											<spring:message code="course.btn.delete" />
										</button>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<th colspan="5" class="text-center"><spring:message
										code="course.table.empty" /></th>
							</tr>
						</c:otherwise>
					</c:choose>
					<tr>
						<th colspan="5">
							<button onclick="location.href='addCourse'"
								class="btn btn-primary">
								<spring:message code="student.btn.add" />
							</button>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>