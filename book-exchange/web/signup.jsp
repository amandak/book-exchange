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
        	First Name: <input type="text" name="fName"/><br>
        	Last Name: <input type="text" name="lanme"/><br>
            Username:<input type="text" name="newusername" /><br>
            E-mail:<input type="text" name="email" /><br>
            Repeat e-mail:<input type="text" name="email2" /><br>
            Password:<input type="password" name="newpassword" /><br>
            Repeat password:<input type="password" name="newpassword2" /><br>
            <input type="submit" value="submit" />
        </form>
		<br>
		<p style="color:red">${signupError}</p>
		
		<a href="index.jsp">home</a>
	</body>
</html>