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
<div class="col-sm-6">
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
					<label class="control-label col-sm-4" for="city">
					city
					</label> 
					<div class="col-sm-6">
						<form:input path="address.city" type="text" class="form-control" id="city" name="city" placeholder="city" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="district">
					district
					</label> 
					<div class="col-sm-6">
						<form:input path="address.district" type="text" class="form-control" id="district" name="district" placeholder="district" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="street">
					street
					</label> 
					<div class="col-sm-6">
						<form:input path="address.street" type="text" class="form-control" id="street" name="street" placeholder="street" readonly="${mode == 'VIEW' }"/>
					</div>
				</div>					
					
				<!-- For adding and updating student -->
						<c:if test="${mode == 'ADD' || mode == 'EDIT'}">
							<div class="form-group">
								<label for="tbCourses" class="control-lable col-md-4" style="text-align:right">Courses
									registered </label>
								<div class="col-md-6">
									<table id="tbCourses" class="table table-bordered">
										<thead>
											<tr>
												<th>Course ID</th>
												<th>Course Name</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${mode == 'EDIT'}">
												<c:forEach items="${student.courses}" var="course">
													<tr onclick="courseClickedForEdit(this)">
														<td>${course.id}</td>
														<td>${course.courseName}</td>
													</tr>
												</c:forEach>
											</c:if>
										</tbody>
									</table>
								</div>
							</div>
						</c:if>

						<div class="form-group" role="group" aria-label="Basic example">
							<div class="col-sm-offset-4 col-sm-6">
								<c:if test="${mode == 'EDIT' ||  mode == 'ADD'}">
									<button type="submit" class="btn btn-primary" name="btnSave"
										id="saveBtn" onclick="getId();">Save</button>
								</c:if>
	
								<c:if test="${mode == 'VIEW'}">
									<button disabled="disabled" type="submit"
										class="btn btn-primary" name="btnSave" id="saveBtn"
										onclick="getId();">Save</button>
								</c:if>
								<button type="button" class="btn btn-danger"
									onclick="location.href='./students'">Cancel</button>
							</div>
						</div>
					</div>

					<!-- For displaying student -->
					<c:if test="${mode == 'VIEW'}">
						<div class="col-md-6">
							<table class="table table-bordered table-dark" id="tbCourses">
								<thead>
									<tr>
										<th>Course ID</th>
										<th>Course Name</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${!empty student.courses}">
										<c:forEach items="${student.courses}" var="course">
											<tr>
												<td>${course.id}</td>
												<td>${course.courseName}</td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
							</table>
						</div>
					</c:if>					
				
			</form:form>
			
		</div>
	</div>
</div>
<div class="col-sm-6">
	<c:if test="${mode == 'EDIT' || mode == 'ADD'}">
		<div class="col-md-6">
			<table class="table table-striped table-dark" id="listCourses">
				<thead>
					<tr>
						<th>Course ID</th>
						<th>Course Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${courses}" var="course">
						<tr onclick="courseClicked(this)">
							<td>${course.id}</td>
							<td>${course.courseName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>Just click on the row contain name of course which you
				want to register</p>
			<br>
			<p>In order to unregister : click that row again</p>
		</div>
	</c:if>
</div>
</body>
</html>