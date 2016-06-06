<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information for card</title>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}

form>ipput#id {
	width: 70%
}
</style>

</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="starter-template">
<c:choose>
	<c:when test="${requestScope.msg == 'bs' }">
	<div class="alert alert-success text-center ">
		<button type="button" class="close" data-dismiss = "alert" aria-label="Close" >
		<span aria-hidden= "true">&times;</span>
	    </button>
		<strong>借阅成功</strong>
	</div>
	</c:when>
	<c:when test="${requestScope.msg =='bf'}">
	<div class="alert alert-warning text-center ">
		<button type="button" class="close" data-dismiss = "alert" aria-label="Close" >
		<span aria-hidden= "true">&times;</span>
	    </button>
		<strong>借阅失败！</strong>
	</div>
	</c:when>
	<c:when test="${requestScope.msg =='rs'}">
	<div class="alert alert-success text-center ">
		<button type="button" class="close" data-dismiss = "alert" aria-label="Close" >
		<span aria-hidden= "true">&times;</span>
	    </button>
		<strong>还书成功！</strong>
	</div>
	</c:when>
	<c:when test="${requestScope.msg =='rf'}">
	<div class="alert alert-warning text-center ">
		<button type="button" class="close" data-dismiss = "alert" aria-label="Close" >
		<span aria-hidden= "true">&times;</span>
	    </button>
		<strong>还书失败！</strong>
	</div>
	</c:when>
</c:choose>
			<form class="form form-group-lg form-group " action="/bookshow"
				method="get">
				<label for="search"></label> <input id="search" name="search"
					type="text" class="text-center form-control"
					placeholder="search for : title /author /press /code" />
				<button class="btn btn-lg btn-primary">Search</button>
			</form>
			<div class="panel panel-primary bg-info " style="background-color: #2aabd2">
				<p class="lead text-center" style= "line-height: 100%" >
					This is detail record information of
					${requestScope.user}
				</p>
			</div>
			<!-- <p class = "sr-only">${requestScope.ccode}</p> -->
			<div class="bs-example" data-example-id="bordered-table">
			
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>书号</th>
							<th>书名</th>
							<th>作者</th>
							<th>出版社</th>
							<th>状态</th>
							<th>借出时间</th>
							<th>归还时间</th>
							<th>借阅天数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var = "real" items="${requestScope.list}" varStatus = "s" >
						<tr <c:if test="${real.station == '已还'}" >class="bg-success"</c:if> >>
							<th scope="row"> ${s.count} </th>
							<td>${real.bcode}</td>
							<td>${real.title}</td>
							<td>${real.author}</td>
							<td>${real.press}</td>
							<td>${real.station}</td>
							<td>${real.brtime}</td>
							<td>${real.retime}</td>
							<td>${real.bday}</td>
							<td>
							<c:if test="${real.station == '借出'}">
								<button data="${real.bcode}"
									class="btn btn-danger btn-xs">续借</button>
								<button data="${real.bcode}"
									class="btn btn-primary btn-xs">归还</button>
							</c:if>
							</td>	
						</tr>			
					</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("ul.nav>li:nth-child(2)").addClass("active");
		$("td>button.btn-primary").bind('click',detail);
	});
	function detail(){
		var i = $(this).attr("data");
		location.href = "/bookreturn?bcode=" + i + "&ccode=" + ${requestScope.ccode} ;
		 
	}
	
	</script>
</body>
</html>

