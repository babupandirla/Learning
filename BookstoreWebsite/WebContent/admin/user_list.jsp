<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<jsp:directive.include file="Header.jsp" />
	<div align="center">
		<h2>Users Management</h2>
	</div>
	<div align="center">
		<a href="user_form.jsp">Create New User</a> &nbsp; <br />
		<br />
	</div>
	<div align="center">
		<h4>${message}</i>
		</h4>
	</div>
	<div align="center">
		<table border=1 cellpadding="5">
			<tr>
				<th>Index</th>
				<th>FullName</th>
				<th>Email</th>
				<th>Id</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${allusers}" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${user.fullName}</td>
					<td>${user.email}</td>
					<td>${user.userId}</td>
					<td><a href="edit_user?id=${user.userId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:Confirmdelete(${user.userId})">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="Footer.jsp" />
</body>
<script >
function Confirmdelete(userId){
	if(userId==1){
		alert("The default admin user account cannot be deleted.");	
	}
	else if (confirm('Are you sure you want to delete user with id'+userId+'?')){
		window.location='delete_user?id='+ userId;
	}
}
</script>
</html>