function getCourses(){
	var rootPath = getContextRootPath();
	location.href = rootPath + "controller/courses";
}

function getContextRootPath(){
	var pathName = location.pathname.substring(1);
	var token = pathName.split("/");
	var rootContextPath = "/" + token[0] + "/";
	
	return rootContextPath;
}
