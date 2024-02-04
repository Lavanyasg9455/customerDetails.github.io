<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer Details</title>
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

#i1, #i2, #i3, #i4, #i5, #i6 {
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

#g{
	margin-left:-5%;
}

p {
	color: #C70039;
	margin-right: 10px;
}

#failure {
	margin-top: 60px;
	color: #C70039;
}

#success {
	margin-top: 60px;
	color: #65B741;
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
	<img src="<c:url value="/resources/images/the-tap-academy-logo-01.png"/>" style="width: 10%; max-height: 150px; margin-top: 10px;margin-left:1px;padding:5px 20px;"/>
	</header>
	
	<center>
		<h2 id="failure">${updateErrorMessage}</h2>
	</center>

<div id="d">
<center>
	<h1 style="color:#43d7ff;">Edit Customer Details</h1><br>
    <form action="updateCustomer/${customerId}" method="post">
    
				<input id=i1 type="text" name="firstName" id="firstName" value="${FIRST_NAME}" placeholder="FIRST NAME" required class="form-control"><br>
				
				<input id=i1 type="text" name="lastName" id="memberEmail" value="${LAST_NAME}" placeholder="LAST NAME" required class="form-control"><br>
				
				<input id=i1 type="text" name="address" id="address" value="${ADDRESS}" placeholder="ADDRESS" required class="form-control"><br>
				
				<input id=i1 type="text" name="city" id="city" value="${CITY}" placeholder="CITY" required class="form-control"><br>
			
				<input id=i1 type="text" name="state" id="state" value="${STATE}" placeholder="STATE" required class="form-control"><br>
				
				<input id=i1 type="email" name="email" id="email" value="${EMAIL}" placeholder="EMAIL" required class="form-control"><br>
				
				<input id=i1 type="number" name="phone" id="phone" value="${PHONE}" placeholder="PHONE" required class="form-control"><br>
								
				<input id="submit" type="submit" value="Update Customer"><br><br>
	</form>	
</center>	
</div>
<footer></footer>
</body>
</html>