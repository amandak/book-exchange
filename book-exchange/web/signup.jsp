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
	
			<div class="header">
				<a class="homeButton" href="index.html">Home</a>
				<c:if test="${userId == null}">
					<div align="right">
						<div class="textAlignRight">
						<a class="smallButton2" href="login.jsp">Login</a>&nbsp&nbsp&nbsp&nbsp 
						<a class="smallButton2" href="signup.jsp">Signup</a>
						</div>
					</div>
				</c:if>
					
				<c:if test="${userId != null}">
					<div align="right">
						<form action="login" method="post" class="textAlignRight">
						<input class="smallButton2" type="submit" name="logout" value="Log Out">
						</form>
		
						<form action="login" method="post" class="textAlignRight">
						<input type="hidden" name="userid" value="${userId}">
						<input type="hidden" name="userView" value="userView">
						<input class="smallButton2" type="submit" name="account" value="My Account">
						</form>
					</div>
				</c:if>		
			</div>    
        
        <div id="newAccountCenterDiv">
			<div id="newAccountPanel">
			<h2>Create New Account</h2>
        	<form method="post" action = "signup">
            Username:<br><input class="newAccountBox" type="text" name="newusername" /><br>
            <br>First Name: <br><input class="newAccountBox" type="text" name="fname" /><br>
        	<br>Last Name: <br><input class="newAccountBox" type="text" name="lname" /><br>
            <br>UGA email:<br><input class="newAccountBox" type="email" name="email" /><br>
            <br>Re-enter e-mail:<br><input class="newAccountBox" type="email" name="email2" /><br>
            <br>Password:<br><input class="newAccountBox" type="password" name="newpassword" /><br>
            <br>Re-enter password:<br><input class="newAccountBox" type="password" name="newpassword2" /><br>
            <br><input class="submitButton" type="submit" value="submit" />
        </form>
        		<p class="errorMsg">${signupError}</p>
			</div>
	
			</div>
		
        
	</body>
</html>
