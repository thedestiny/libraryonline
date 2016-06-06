<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>

</head>
<body>
<%@ include file="nav.jsp" %>
	<div class="container">
		<div class="starter-template">
			<h1>Rules for attention:</h1>
			<p class="lead">
				Welcome to our library to borrow Book:<br/>
		</div>
	</div>
<script>
	$("#borrowid").addClass("active");
</script>
</body>
</html>
