# customerDetails.github.io
Customer Details
Add files via upload
# Customer Management System

This is a CRUD (Create, Read, Update, Delete) application for managing customers. It provides APIs for performing these operations on a MySQL database using Spring MVC.

## Technologies Used

- Backend: Spring MVC
- Frontend: HTML, CSS
- Database: MySQL

## Getting Started

To run this project locally, follow these steps:

1)Set up the MySQL database:

Create a MySQL database named customer.

2)Run the application:

Import the project into your preferred IDE (I have used Eclipse)
Configure your IDE to run a web application using Apache Tomcat 
Run the application from your IDE.

3)Access the application:

Open your web browser and go to http://localhost:8080/customerDetails/

a)Create a customer:

URL: http://localhost:8080/customerDetails/getAddCustomerPage
Method: POST
Request Body: Form data containing customer details (FirstName, LastName, Address,City, State,Email, Phone)

Update a customer:

URL: http://localhost:8080/customerDetails/editCustomer/{customerId}
Method: POST
Request Body: Form data containing updated customer details

Get a list of customers:

URL: http://localhost:8080/customerDetails/viewAllButton
Method: GET

Query Parameters:

page: Page number for pagination 
size: Number of records per page 
sort: Sorting field and order 
search: Search keyword to filter customers 

Get a single customer based on ID:

URL: http://localhost:8080/customerDetails/search?searchBy=firstName&searchQuery={FirstName}
Method: GET

Delete a customer:

URL: http://localhost:8080/customerDetails/deleteCustomer/{customerId}
Method: POST

*First we need to create the Maven Project in that we have to give artifact Id and Group Id we need to gave and packaging should be war we need to select.
*Then the Project will be created we need setup the Configuration files Like dispatcherServlet-servlet.xml, hibernate.cfg.xml, web.xml, pom.xml.
*And also, I followed here MVC Design Pattern i.e., Model View Control 
*After setup all these configuration files and By using MVC design pattern  we need to write the code and run by using the URL: http://localhost:8080/customerDetails/

NOTE:
This application i have developed only for particular organization so there is no Register Page to use registration
Login Id: test@sunbasedata.com
Password: Test@123

This is Video Link of My Project(Customer_Details): https://drive.google.com/file/d/1Svu2QKtTZKo3SlSCPc3_yI5ybsZ9Xxu2/view?usp=sharing

Privously I have done one project Called VaccinApp Portal Using Spring MVC 
This is my GitHub Link: https://github.com/Lavanyasg9455/VaccineApp
This is Video Link of the VaccineApp Portal Project: https://drive.google.com/file/d/1LSUZii3nfNVsvmp8iBD_xRG9KlSAO7GY/view?usp=sharing

