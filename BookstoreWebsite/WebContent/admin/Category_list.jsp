<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Management</title>
</head>
<body>
	<jsp:directive.include file="Header.jsp" />
	<div align="center">
		<h2>Category Management</h2>
	</div>
	<div align="center">
		<a href="Category_form.jsp">Create New Category</a> &nbsp; <br />
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
				<th>Category_id</th>
				<th>Category_name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="Category" items="${listallcategories}" varStatus="status">
				<tr>
					<td align="center">${status.index+1}</td>
					<td align="center">${Category.categoryId}</td>
					<td align="center">${Category.name}</td>
					<td><a href="edit_category?id=${Category.categoryId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:Confirmdelete(${Category.categoryId})">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center"></div>
	<jsp:directive.include file="Footer.jsp" />
</body>
<script >
function Confirmdelete(categoryId){
if (confirm('Are you sure you want to delete category with id'+categoryId+'?')){
		window.location='delete_category?id='+ categoryId;
	}
}
</script>
</html>