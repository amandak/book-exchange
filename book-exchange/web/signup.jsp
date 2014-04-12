<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Signup</title>
	</head>
	<body>
		<p>Signup:</p>
        <form method="post" action = "login">
            Username:<input type="text" name="username" /><br>
            E-mail:<input type="text" name="email" /><br>
            Repeat e-mail:<input type="text" name="email2" /><br>
            Password:<input type="password" name="password" /><br>
            Repeat password:<input type="password" name="password2" /><br>
            <input type="submit" value="submit" />
        </form>
		<br>
		<a href="index.jsp">home</a>
	</body>
</html>