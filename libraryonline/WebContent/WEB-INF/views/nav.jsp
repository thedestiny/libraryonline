<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- include file="key.jsp"  -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Library</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/home">Home</a></li>
					<li class="dropdown" id = "bookid">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="/home">Book<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                           <li><a href="/bookshow">Show all</a></li>
                            <c:if test="${sessionScope.custom == null}">
                       			<li><a href="/bookadd">Add book</a></li>
                   			 </c:if>                      
                        <li><a href="#">ABC</a></li>
                         </ul>
                    </li>
                    <c:if test="${sessionScope.custom == null}">
                    <li><a href="/cardhome">Card</a></li>
                    </c:if>                   
					<li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="/bookborrow?id=100601">B&Rbook<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                           <li><a href="/bookborrow?id=100601">Borrow</a></li>
                           <li><a href="#">Return</a></li>
                           <li><a href="#">ABC</a></li>
                         </ul>
                    </li>
					<li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">Information<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                           <li><a href="/inforcard?infor=${sessionScope.custom}">Inforcard</a></li>
                           <li><a href="#">inforBook</a></li>
                           <li><a href="#">ABC</a></li>
                         </ul>
                    </li>
				</ul>
				<ul class = " nav navbar-nav  navbar-right" >
					<li ><a href="#">${sessionScope.user}${sessionScope.name},欢迎登陆！</a></li>
					<li id = "quit"><a href="#" class="btn btn-defalut btn-sm" >安全退出</a></li>
					<li ><a href="#" class="btn btn-defalut btn-sm" >当前在线人数：${applicationScope.count}</a></li>				
				</ul>
			
			</div>
		</div>
	</nav>

	
