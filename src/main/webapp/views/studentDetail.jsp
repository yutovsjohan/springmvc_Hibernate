<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title><spring:message code="student.detail.label" /></title>
</head>
<body>

	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">
			<spring:message code="student.detail.label" />
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th><spring:message code="student.table.id" /></th>
						<th><spring:message code="student.table.name" /></th>
						<th><spring:message code="student.table.age" /></th>
						<th><spring:message code="student.table.address" /></th>
						<th><spring:message code="student.table.action" /></th>
					</tr>
				</thead>
				<c:choose>
					<c:when test="${!empty students }">
						<c:forEach items="${students }" var="student">
							<tr>
								<td>${student.id }</td>
								<td>${student.firstName } ${student.lastName }</td>
								<td>${student.age }</td>
								<td>${student.address.street } ${student.address.district }, ${student.address.city }</td>
								<td>
									<button class="btn btn-info" onclick="getStudent(${student.id}, 'VIEW');">
										<spring:message code="student.btn.view" />
									</button>
									<button class="btn btn-primary" onclick="getStudent(${student.id}, 'EDIT');">
										<spring:message code="student.btn.edit" />
									</button>
									<button class="btn btn-danger" onclick="getStudent(${student.id}, 'VIEW');">
										<spring:message code="student.btn.delete" />
									</button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="5" class="text-center"><spring:message code="student.btn.empty" /></th>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<th colspan="5">
						<button onclick="location.href='addStudent'" class="btn btn-primary">
							<spring:message code="student.btn.add" />
						</button>
					</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>