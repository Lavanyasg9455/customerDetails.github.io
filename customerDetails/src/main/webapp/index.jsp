<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login Page</title>
<style>
@charset "UTF-8";

header {
	background: linear-gradient(116.93deg, #3f4954 1%, #26292d 80%);
	height: 60px;
	width: 100%;
	position: fixed;
	top: 0;
	z-index: 1000;
}

footer {
	background: linear-gradient(116.93deg, #3f4954 1%, #26292d 80%);
	height: 60px;
	width: 100%;
	position: fixed;
	bottom: 0;
	z-index: 1000;
}
span {
	display: inline-block;
	margin-top:13.4px;
	margin-left: 82%;
}

#a {
	text-decoration: none;
	background-color: #43d7ff;
	border: 3px solid #43d7ff;
	font-family: serif;
	font-size: 22px;
	border-radius: 5px;
	color: #26292d;
	padding:5px 5px;
}

#a:hover {
	border-color: #FFC436;
}

aside {
	font-size: 40px;
	padding-top: 10%;
	font-weight: bold;
	padding-bottom: 23.8%;
	color:  #26292d;
	text-align: justify;
}

body {
	background-color: #FFFFFF;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

</style>
</head>
<body style="background-image: url('/vaccineApp/resources/images/employee3.jpg'); background-position: top;margin: 0; padding: 0; display: flex; background-size: 1000px;background-color:#43d7ff;">
	<header>
	<center>
		<span>
		<a id="a" href="getLoginPage" class="btn-btn-primary">Login</a>
		</span>
	</center>
	<img src="<c:url value="/resources/images/the-tap-academy-logo-01.png"/>" style="width: 10%; max-height: 150px; margin-top: -40px;margin-left:1px;padding:5px 5px;"/>
	</header>
	<marquee>
	<aside>Welcome To The Customer Portal</aside>
	</marquee>
	<footer></footer>
</form> 
</body>
</html>