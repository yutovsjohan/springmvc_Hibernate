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
	src="<c:url value="/resources/js/students.js" />"></script>
<title>Student List</title>
</head>
<body>
	<div class="panel panel-default">
		<div id="title" class="panel-heading h3 text-center">
			List Student
		</div>
		<div class="panel-body">
			<table class="table table-striped" id="studentHome">
				<thead>
					<tr>
						<th>ID</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Age</th>
						<th>Address</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty students}">
							<c:forEach items="${students}" var="student">
								<tr>
									<td>${student.id}</td>
									<td>${student.firstName}</td>
									<td>${student.lastName}</td>
									<td>${student.age}</td>
									
									<c:forEach items="${addresses}" var="address">
										<c:if test="${address.id == student.id }">
											<td>district ${address.district}, ${address.street} street, ${address.city} city</td>
										</c:if>
									</c:forEach>
																										
									<td>
										<button class="btn btn-info" onclick="getStudent(${student.id}, 'VIEW');">
											VIEW
										</button>
										<button class="btn btn-warning" onclick="getStudent(${student.id}, 'EDIT');">
											EDIT
										</button>
										<button class="btn btn-danger" onclick="deleteStudent(${student.id}, this);">
											DELETE
										</button>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<th colspan="6" class="text-center">List empty</th>
							</tr>
						</c:otherwise>
					</c:choose>
					<tr>
						<th colspan="6">
							<button onclick="location.href='addStudent'"
								class="btn btn-primary">
								ADD
							</button>
						</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>