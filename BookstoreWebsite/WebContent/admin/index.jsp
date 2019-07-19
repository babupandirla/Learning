<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Bookstore</title>
</head>
<body>
	<jsp:directive.include file="Header.jsp" />	
	<div align="center">
	<h2>Administrative Dashboard </h2>
	
	</div >
	<div align="center">
	<hr width="60%"/>
	<h2>Quick Actions:</h2>
	<b>
	<a href="Create_User">New User</a> &nbsp;
	<a href="Create_Book">New Book</a> &nbsp;
	<a href="Create_Category">New Category</a> &nbsp;
	<a href="Create_Customer">New Customer</a> 
	</b>
	</div>
	<div align="center">
	<hr width="60%"/>
	<h2>Recent sales:</h2>
	</div>
	<div align="center">
	<hr width="60%"/>
	<h2>Recent Reviews:</h2>
	</div>
	<div align="center">
	<hr width="60%"/>
	<h2>Statistics:</h2>
	</div >
	<hr width="60%"/>
	<jsp:directive.include file="Footer.jsp" />
</body>
</html>