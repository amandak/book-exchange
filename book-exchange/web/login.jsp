<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<div class="header"> <a class="homeButton" href="index.jsp">Home</a></div>		
		
		<div id="loginCenterDiv">
			<div id="loginPanel">
			<H2>Login</H2>
        	<form method="post" action = "login">
            	Username:</br><input id="loginBox" type="text" name="username" /><br>
            	Password:</br><input id="loginBox" type="password" name="password" /><br></br>
            	<input class="submitButton" type="submit" value="submit" />
        	</form>
	      		<p class="errorMsg">${loginError}</p>
			</div>
			
			<div id="createAccount"> Don't have an account? <a href="" id="signUpButton">Create New Account</a>
			</div>
		</div>
	</body>
</html>