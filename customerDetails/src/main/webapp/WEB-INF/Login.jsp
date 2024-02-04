<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	#d {
	border: #3f4954 solid 1px;
	margin-top: 75px;
	margin-bottom: 110px;
	margin-left: 30%;
	margin-right: 30%;
	padding-left: 40px;
	padding-right: 40px;
	padding-top: 10px;
	background-color: #FFFFFF;
	border-radius: 30px;
}

#submit {
	margin-right: 22px;
	font-size: 22px;
	background: linear-gradient(to right, #26292d, #43d7ff);
	border: none;
	color: white;
	cursor: pointer;
	transition: background 0.3s;
	border-radius: 5px;
	display: inline-block;
}
header {
	background: linear-gradient(116.93deg, #3f4954 1%, #26292d 80%);
	height: 60px;
	width: 100%;
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
	margin-left:90%;
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

body {
	background-color: #FFFFFF;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

#failure {
	margin-top: 30px;
	color: #C70039;
}

#success {
	margin-top: 30px;
	color: #65B741;
}

</style>
</head>
<body>
<header>
	<center>
		<span>
		</span>
	</center>
	<img src="<c:url value="/resources/images/the-tap-academy-logo-01.png"/>" style="width: 10%; max-height: 150px; margin-top: -30px;margin-left:1px;padding:5px 20px;"/>
	</header>
	<center>
		<h2 id=failure>${loginMessage1}</h2>
	</center>
 <div id="d">
<center>
<form action="loginPage" method="post">
<img src="<c:url value="/resources/images/Login.png"/>" style="width: 30%; max-height: 120px; margin-top: 1px;"/>

<input id="" type="email" name="loginId" id="loginId" placeholder="LoginId*" required class="form-control"><br>

<input id="" type="password" name="password" id="password" placeholder="Password*" required class="form-control"><br>


<input id="submit" type="submit" value="Login"><br><br>

</form>
</center>
</div>
<footer></footer>
</body>
</html>