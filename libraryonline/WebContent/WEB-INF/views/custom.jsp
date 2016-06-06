<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body> 
<c:choose>
	<c:when test="${requestScope.err == '1001' }">
	<div class="alert alert-warning text-center ">
		<button type="button" class="close" data-dismiss = "alert" aria-label="Close" >
		<span aria-hidden= "true">&times;</span>
	    </button>
		<strong>登陆失败！</strong>
	</div>
	</c:when>
</c:choose>

<div class="container">
      <form method= "post" class="form-signin"  action= "/custom"  >
        <h2 class="form-signin-heading">欢迎登陆</h2>
        <label for="inputEmail" class="sr-only">User number</label>
        <input type="text" name = "custom" id="inputEmail" class="form-control" placeholder="User number" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name= "pass" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input name= "dog" type="checkbox" value="remember"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div> 
</body>
</html>

