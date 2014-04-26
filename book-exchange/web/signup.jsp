<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create New Account</title>
	</head>
	
	<body>
		<div class="header"> <a class="homeButton" href="index.jsp">Home</a></div>	
        
        <div id="newAccountCenterDiv">
			<div id="newAccountPanel">
			<h2>Create New Account</h2>
        	<form method="post" action = "signup">
        	First Name: <br><input class="newAccountBox" type="text" name="fname" /><br>
        	<br>Last Name: <br><input class="newAccountBox" type="text" name="lname" /><br>
            <br>Username:<br><input class="newAccountBox" type="text" name="newusername" /><br>
            <br>UGA email:<br><input class="newAccountBox" type="text" name="email" /><br>
            <br>Re-enter e-mail:<br><input class="newAccountBox" type="text" name="email2" /><br>
            <br>Password:<br><input class="newAccountBox" type="password" name="newpassword" /><br>
            <br>Re-enter password:<br><input class="newAccountBox" type="password" name="newpassword2" /><br>
            <br><input class="submitButton" type="submit" value="submit" />
        </form>
        		<p class="errorMsg">${signupError}</p>
			</div>
	
			</div>
		
        
	</body>
</html>
