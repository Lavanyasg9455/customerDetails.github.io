<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login Form</title>
<link rel="stylesheet" href="<c:url value="/resources/css/homePage.css"/>">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<br>
<style>
#r {
	display: inline-block;
	margin-left: 73.5%;
}

.b {
	text-decoration: none;
	background-color: #C499F3;
	border: 3px solid #C499F3;
	font-family: serif;
	font-size: 20px;
	border-radius: 5px;
	color: #26292d;
	margin-top: 0px;
}

#black {
	text-decoration: none;
	background-color: green;
	border: 3px solid green;
	font-family: serif;
	font-size: 20px;
	border-radius: 5px;
	color: #26292d;
	margin-top: 0px;
	padding: 2px 2px;
}

#red {
	text-decoration: none;
	background-color: red;
	border: 3px solid red;
	font-family: serif;
	font-size: 20px;
	border-radius: 5px;
	color: #26292d;
	margin-top: 0px;
	padding: 2px 2px;
}

#search {
	text-decoration: none;
	background-color: #3559E0;
	border: 3px solid #3559E0;
	font-family: serif;
	font-size: 18px;
	color: white;
	border-radius: 10px;
	margin-top: 0px;
}

#f select, #f input {
	margin-right: 10px;
}

.b, #f {
	display: inline-block;
	vertical-align: top;
}

#f select, #f option {
	text-decoration: none;
	background-color: #C499F3;
	border: 3px solid #C499F3;
	font-family: serif;
	font-size: 20px;
	border-radius: 5px;
	color: #26292d;
	margin-top: 0px;
	padding: 2px, 2px;
}
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
}

#l {
	display: inline-block;
	margin-top: 10px;
}

#p1 {
	margin-top: -30px;
	margin-left: 40%;
	color: #FFC436;
	font-weight: bold;
	font-family: serif;
	font-size:16px;
	position: fixed;
	z-index: 1000;
}

#r {
	margin-top: 10px;
	margin-left: 73%;
	position: fixed;
	z-index: 1000;
}

#success {
	margin-top: 30px;
	color: #65B741;
	font-size: 30px;
	padding-top: 10%;
	font-weight: bold;
	padding-bottom: 20%;
}

.a {
	text-decoration: none;
	background-color: #43d7ff;
	border: 3px solid #43d7ff;
	font-family: serif;
	font-size: 20px;
	border-radius: 5px;
	color: #26292d;
	margin-top: 0px;
	padding:5px 5px;
}

.a:hover {
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

button {
	margin-top: 0px;
	margin-left: 20px;
	margin-right: 80%;
	display: inline-block;
	margin-right: 70%;
}
</style>
</head>
<body>
	<form>
		<header>
		
		<script>
			function go() {
				window.location.replace("Logout.jsp",'window','toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
				self.close()
			}
		</script>
			<span>
			&nbsp;<a class="a" id="l" href="logout" class="btn-btn-primary">Back</a>&nbsp;&nbsp;&nbsp;
			<a class="a" href="viewAllButton" class="btn-btn-primary">View All Customers</a> 
			
			
			<%
				String str = request.getParameter("userEmail");
				session.setAttribute("EMAIL", request.getParameter("userEmail"));
			%>
			<h5 id="p1">User:<%=session.getAttribute("userEmail")%></h5>
			<%
				if (session.getAttribute("userEmail").equals("")) {
			%>
				<a class="a" href="getLoginPage" class="btn-btn-primary">Login</a>
			<%
				} else {
			%>
				<a class="a" id="r"  href="javascript:go()" class="btn-btn-primary">Logout</a>
			<%
				}
			%>
			</span>
		</header>
		</form>
	<center>
		<p class="center" style= "color:white; background-color:green; width:fit-content">${successMessage}</p>
		<p class="center" style= "color:white; background-color:red; width:fit-content">${tableErrorMessage}</p>
	</center><br><br>
	<span>
	<div class="container">
	<h1 class="text-center">Customer Details</h1><br>
		<a class="b" href="getAddCustomerPage" class="btn-btn-primary">Add Customer</a>&nbsp;
			<form id="f" action="search" method="get">
			<select class="b" name="searchBy">
				<option value="SearchBy">Search By</option>
				<option value="firstName">First Name</option>
				<option value="lastName">Last Name</option>
				<option value="city">City</option>
				<option value="email">Email</option>
			</select> 
			<input type="search" name="searchQuery" placeholder="Enter search keyword"> 
			<input id="search" type="submit" value="Search">
		</form><br><br>
</div>
	</span>
	<div class="container">
		<table class="table table-bordered">
		<thead class="table-dark">
			<tr>
				<th>FIRST_NAME</th>
				<th>LAST_NAME</th>
				<th>ADDRESS</th>
				<th>CITY</th>
				<th>STATE</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.address}</td>
					<td>${customer.city}</td>
					<td>${customer.state}</td>
					<td>${customer.email}</td>
					<td>${customer.phone}</td>
					<td><a id="black" href="editCustomer/${customer.customerId}">Edit</a></td>
					<td><a id="red" href="deleteCustomer/${customer.customerId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
		<!-- Add pagination controls -->
<c:if test="${totalPages > 1}">
    <ul class="pagination">
        <c:if test="${currentPage > 0}">
            <li class="page-item">
                <a class="page-link" href="?page=${currentPage - 1}&size=${size}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:forEach var="i" begin="0" end="${totalPages - 1}">
            <li class="page-item ${i == currentPage ? 'active' : ''}">
                <a class="page-link" href="?page=${i}&size=${size}">${i + 1}</a>
            </li>
        </c:forEach>
        <c:if test="${currentPage < totalPages - 1}">
            <li class="page-item">
                <a class="page-link" href="?page=${currentPage + 1}&size=${size}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</c:if>
		<footer></footer>
</body>
</html>