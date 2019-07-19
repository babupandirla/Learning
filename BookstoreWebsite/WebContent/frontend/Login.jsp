<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<jsp:directive.include file="Header.jsp" />
	<div align="center">
		<h1>Please login</h1>
		<form>
		Email:<input type="text"  size="15"><br/><br/>
		Password:<input type="password" size="15">
		<input type="submit" value="Login"/>
		</form>	
	</div>
	<jsp:directive.include file="Footer.jsp" />
</body>
</html>