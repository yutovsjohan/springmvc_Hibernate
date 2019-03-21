function getStudents(){
	var rootPath = getContextRootPath();
	location.href = rootPath + "controller/students";
}

function getStudent(id, mode){
	location.href = "student?id=" + id + "&mode=" + mode;
}

//Delete a student
function deleteStudent(id, row) {
	var result = confirm("Do you want to delete this course ?")
	if (result){
		deleteStudentOnTable(id, row);
		sendDeleteRequest("./student/" + id, null);
	}
}

function deleteStudentOnTable(id, row){
	var table = document.getElementById("studentHome");
	var tbody = table.getElementsByTagName("tbody");
	var tr = tbody[0].getElementsByTagName("tr");
	tbody[0].deleteRow(tr[row.rowIndex-1]);
}

function sendDeleteRequest(url, callback) {
	sendRequest(url, "", "DELETE", callback);
}

function sendRequest(url, data, method, callback) {
	$.ajax({
		url : url,
		data :JSON.stringify(data),
		type : method,
		contentType : "application/json",
		success : callback,
		error : function(request, msg, error) {
		}
	});
}

// This function get list of course id for adding student + courses
function getId() {
	var strId = "";
	var table = document.getElementById("tbCourses");
	var tbody = table.getElementsByTagName("tbody");
	var tr = tbody[0].getElementsByTagName("tr");
	var td
	for (var i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		if (i != tr.length - 1)
			strId += (td[0].innerHTML + ",");
		else
			strId += td[0].innerHTML;

	}
	var btn = document.getElementById("saveBtn");
	btn.value = strId;
}

// This function to add a new row for Courses Registered table on UI
// When user click on course name on List Courses on UI
function addToTable(id, cname) {
	var coursesRegistered = document.getElementById("tbCourses");
	var tbody = coursesRegistered.getElementsByTagName("tbody");
	var tr = document.createElement("tr");
	var td = document.createElement("td");
	var text = document.createTextNode(id);
	td.appendChild(text);
	tr.appendChild(td);
	tbody[0].appendChild(tr);
	td = document.createElement("td");
	text = document.createTextNode(cname);
	td.appendChild(text);
	tr.appendChild(td);
	tbody[0].appendChild(tr);
}

function exist(id) {
	var coursesRegistered = document.getElementById("tbCourses");
	var tbody = coursesRegistered.getElementsByTagName("tbody");
	var tr = tbody[0].getElementsByTagName("tr");
	var td;
	for (var i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		if (td[0].innerHTML == id)
			return true;
	}
	return false;
}

// This function to delete a row for Courses Registered table
// When user do not want to register that course
function deleteARow(id) {
	var coursesRegistered = document.getElementById("tbCourses");
	var tbody = coursesRegistered.getElementsByTagName("tbody");
	var tr = tbody[0].getElementsByTagName("tr");
	var td;
	for (var i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		if (td[0].innerHTML == id)
			tbody[0].deleteRow(i);
	}
}

// This function will change the background color of row is click
// when user cick a course on List Course table
function courseClicked(x) {
	var listCourses = document.getElementById("listCourses");
	if (x.style.backgroundColor == "red") {
		x.style.backgroundColor = "";
		var listCourses = document.getElementById("listCourses");
		var tr = listCourses.getElementsByTagName("tr");
		var td = tr[x.rowIndex].getElementsByTagName("td");
		deleteARow(td[0].innerHTML);
	} else {
		var tr = listCourses.getElementsByTagName("tr");
		var td = tr[x.rowIndex].getElementsByTagName("td");
		if (exist(td[0].innerHTML))
			alert("This course is registered!!!");
		else {
			var listCourses = document.getElementById("listCourses");
			x.style.backgroundColor = "red";
			addToTable(td[0].innerHTML, td[1].innerHTML);
		} 
	}
}

// for delete course in editing feature
function courseClickedForEdit(x) {
	var result = confirm("Do you want to delete this course?");
	if (result) {
		var coursesRegistered = document.getElementById("tbCourses");
		var tbody = coursesRegistered.getElementsByTagName("tbody");
		// VÌ INDEX LÀ SỐ THỨ TỰ NÊN PHẢI TRỪ 1
		tbody[0].deleteRow(x.rowIndex - 1);
	}
}