<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add_Member_Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

<style>
header {
	background: linear-gradient(116.93deg, #3f4954 1%, #26292d 80%);
	height: 60px;
	width: 100%;
}

footer {
	background: linear-gradient(116.93deg, #3f4954 1%, #26292d 80%);
	height: 60px;
	width: 100%;
}
span {
	display: inline-block;
	margin-top: 13.4px;
	margin-right: 80%;
	margin-left:10px;
}

#a {
	text-decoration: none;
	background-color:#43d7ff;
	border:3px solid #43d7ff;
	font-size:20px;
	font-family: serif;
	border-radius:5px;
	color:#26292d;
	padding:5px 5px;	
}

#a:hover {
	border-color: #FFC436;
}

body {
	background-color: #FFFFFF;
	padding: 0;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

#d {
	border: #3f4954 solid 1px;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 28%;
	margin-right: 28%;
	padding-left: 15px;
	padding-right: 15px;
	padding-top: 10px;
	background-color: #FFFFFF;
	border-radius: 30px;
}

#i1 {
	cursor: pointer;
	border-radius: 5px;
}

h1 {
	color: #43d7ff;
	font-family: serif;
}

h2 {
	color: #C70039;
}

input:hover {
	border-color: #43d7ff;
}

#div {
	color:#43d7ff;
	font-size: 18px;
}


#failure {
	margin-top: 60px;
	color: #C70039;
}

#success {
	margin-top: 30px;
	color:#004225;
}

.center{
		margin-left:30%;
		margin-right:26%;
		width:40%;
		font-family:Copperplate;
		font-size:20px;
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


</style>

</head>
<body>
	<header>
	<span>
		<a id="a" href="getBackHomePage" class="btn-btn-primary">Back</a>
	</span>

	</header>
	
	<center>
		<h1 style="color:green;">${customerMessage}</h1>
		<h2 style="color:red;">${customerErrorMessage}</h2>
	</center>

<div id="d">
<center>
	<form action="addCustomer" method="post">
				<h1 style="color:#43d7ff;">Customer Details</h1><br>
				
				<input id=i1 type="text" name="firstName" id="firstName" value="" placeholder="FIRST NAME" required class="form-control"><br>
				
				<input id=i1 type="text" name="lastName" id="memberEmail" value="" placeholder="LAST NAME" required class="form-control"><br>
				
				<input id=i1 type="text" name="address" id="address" value="" placeholder="ADDRESS" required class="form-control"><br>
				
				<input id=i1 type="text" name="city" id="city" value="" placeholder="CITY" required class="form-control"><br>
			
				<input id=i1 type="text" name="state" id="state" value="" placeholder="STATE" required class="form-control"><br>
				
				<input id=i1 type="email" name="email" id="email" value="" placeholder="EMAIL" required class="form-control"><br>
				
				<input id=i1 type="number" name="phone" id="phone" value="" placeholder="PHONE" required class="form-control"><br>
				
				<input id="submit" type="submit" value="Submit"><br><br>
	</form>	
</center>	
</div>
<footer></footer>
</body>
</html>