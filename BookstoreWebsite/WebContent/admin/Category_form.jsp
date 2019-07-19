<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details</title>
</head>
<body>
<jsp:directive.include file="Header.jsp" />	
	<div align="center">
	<h2>
		<c:if test="${editCategory != null}">
			Edit Category
		</c:if>
		<c:if test="${editCategory == null}">
			Create Category
		</c:if>
	</h2>
	</div>	
	<div align="center">
	<c:if test="${editCategory != null}">
			<form action="update_Category" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name=CategoryId value="${editCategory.categoryId}"/>
		</c:if>
	<c:if test="${editCategory == null}">
			<form action="create_Category" method="post" onsubmit="return validateFormInput()">
		</c:if>
	<c:if test="${errormessage!= null}">
	<h3>${errormessage}</h3>
	</c:if>
	<table>
	<tr>
		<td align="right">CategoryName:</td>
		<td align="left"><input type="text" id="CategoryName" name="CategoryName" size="20" value="${editCategory.name}"/></td>
	</tr>	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="save"/>
		<input type="Button" value="Cancel" onclick="javascript:history.go(-1)" /></td>
	</tr>
	</table>
	</form>
	</div>
	<div align="center">
	
	</div >
	<jsp:directive.include file="Footer.jsp" />
</body>
<script type="text/javascript">
	function validateFormInput(){
		
		var fieldCategoryName = document.getElementById("CategoryName");		
		if(fieldCategoryName.value.length == 0){
		alert("CategoryName field is required!");
		fieldCategoryName.focus();
		return false;
		}
		return true;
	}
</script>
</html>