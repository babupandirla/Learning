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
		<c:if test="${edituser != null}">
			Edit User
		</c:if>
		<c:if test="${edituser == null}">
			Create User
		</c:if>
	</h2>
	</div>	
	<div align="center">
	<c:if test="${edituser != null}">
			<form action="update_user" method="post" onsubmit="return validateFormInput()">
			<input type="hidden" name="userId" value="${edituser.userId}"/>
		</c:if>
	<c:if test="${edituser == null}">
			<form action="create_user" method="post" onsubmit="return validateFormInput()">
		</c:if>
	<c:if test="${errormessage!= null}">
	<h3>${errormessage}</h3>
	</c:if>
	<table>
	<tr>
		<td align="right">Email:</td>
		<td align="left"><input type="text" id="Email" name="Email" size="20" value="${edituser.email}"/></td>
	</tr>
	<tr>
		<td align="right">FullName:</td>
		<td align="left"><input type="text" id="FullName" name="FullName" value="${edituser.fullName}" size="20"/></td>
	</tr>
	<tr>
		<td align="right">Password:</td>
		<td align="left"><input type="password"  id="Password" name="Password" value="${edituser.password}"size="20"/></td>
	</tr>
	<tr><td>&nbsp;</td></tr>
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
		
		var fieldemail = document.getElementById("Email");
		var fieldpassword = document.getElementById("Password");
		var fieldname = document.getElementById("FullName");
		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if (reg.test(fieldemail.value)==false)
			{
			alert("Invalid email")
			return false;
			}
		if(fieldemail.value.length == 0||fieldpassword.value.length == 0||fieldname.value.length == 0){
		alert("Email && password && Name fields are required!");
		fieldemail.focus();
		return false;
		}
		return true;
	}
</script>
</html>