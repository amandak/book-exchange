<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<p>Login:</p>
        <form method="post" action = "login">
            Username:<input type="text" name="username" /><br>
            Password:<input type="password" name="password" /><br>
            <input type="submit" value="submit" />
        </form>
		<a href="index.jsp">home</a>
		
		
		<p style="color:red">${loginError}</p>
	</body>
</html>