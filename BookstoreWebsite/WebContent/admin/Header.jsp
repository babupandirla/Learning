<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="./../css/styles.css">
</head>
<body>
<div class="header">
	<div class="admin-logo">
		<img style="height: 100px;"src="./../images/admin.png" /><br/>			
	</div>
	<div class="middle">
		<div>
		Welcome Admin Bro, <a href="./../frontend/logout.html">Logout</a>
		</div>
		<br>
		<div >
			
			<a href="list_users">Users</a>	|
			<a href="list_Categories">Categories</a> |
			<a href="Books">Books</a> |
			<a href="Customers">Customers</a>
			<a href="Reviews">Reviews</a> |
			<a href="Orders">Orders</a>
		</div>
	</div>
</div>
</body>
</html>