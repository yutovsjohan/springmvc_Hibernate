function getCourses(){
	var rootPath = getContextRootPath();
	location.href = rootPath + "controller/courses";
}

function getCourse(id, mode){
	location.href = "course?id=" + id + "&mode=" + mode;
}

function deleteCourse(id) {
	location.href = "course/" + id;
}

function getContextRootPath(){
	var pathName = location.pathname.substring(1);
	var token = pathName.split("/");
	var rootContextPath = "/" + token[0] + "/";
	
	return rootContextPath;
}

function sendRequest(url, data, method, callback) {
	$.ajax({
		url : url,
		type : method,
		data : data,
		contentType : 'application/json',
		success : callback,
		error : function(request, msg, error){}
	});
};

function sendDeleteRequest(url, callback) {
	sendRequest(url, "", 'DELETE', callback);
}

function deleteCourse(id) {
	var result = confirm("Do you want to delete this course ?");
	if(result == true){
		sendDeleteRequest('./course/' + id, function(){location.href='./courses';});
	}
}