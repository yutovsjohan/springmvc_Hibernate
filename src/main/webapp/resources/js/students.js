function getStudents(){
	var rootPath = getContextRootPath();
	location.href = rootPath + "controller/students";
}

function getStudent(id, mode){
	location.href = "student?id=" + id + "&mode=" + mode;
}

function deleteStudent(id) {
	location.href = "student/" + id;
}

function getContextRootPath(){
	var pathName = location.pathname.substring(1);
	var token = pathName.split("/");
	var rootContextPath = "/" + token[0] + "/";
	
	return rootContextPath;
}

