<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
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
	margin-top: 13.4px;
	margin-left: 90%;
	margin-bottom:30px;
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
	color: #26292d;
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
h1{
		text-align:center;
		color: #65B741;
		font-size:30px;
		font-family:times new roman;
		font-weight:bold;
	}
</style>
</head>
<body style="background-image: url('/customerDetails/resources/images/background_image9.jpg'); background-position: top;margin: 0; padding: 0; display: flex; background-size: 1300px;">
	<header>
		<span> <a id="a" href="getLoginPage" class="btn-btn-primary">Login</a></span>
		<img src="<c:url value="/resources/images/the-tap-academy-logo-01.png"/>" style="width: 10%; max-height: 150px; margin-top: -120px;margin-left:1px;padding:5px 20px;"/>
	</header>
	<aside>
		<h1>You have logged out successfully</h1>
		<h1>Please login again...</h1>
		<h1>Thank you!</h1>
	</aside>
	<footer> </footer>
</body>
</html>