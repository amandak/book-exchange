<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Account</title>
	</head>
	
	<body>

	<div class="header">
		<a class="homeButton" href="index.jsp">Home</a>
		<div align="right">

				<form action="login" method="post">
					<input class="smallButton" type="submit" name="logout" value="Log Out">
				</form>

			</div>
	</div>
	<div class="siteTitlePage">My Account</div>
	<div class="backPanel">
		<div class="panelContent">

			
			<br><br>
			<div>
				<div class="dashedBorder">
					<h2 class="centerText">My Account Information</h2>	
					<p class="dashedBorderContent">
							Name: ${user.fname} ${user.lname}
						<br>Username: ${user.username}
						<br>Email: ${user.email}
						<br>
					</p>				
				</div>
				<br><br>
			
				<div id="menu" class="dashedBorder">
					<h2 class="centerText">Books I'm Selling</h2>
					<div class="dashedBorderContent">
						<form action="addBook.html" method="post">
							<input class="smallButton" type="submit" value="Sell A Book">
						</form>
						<form action="bookQuery" method="get">
							<input type="hidden" name="listBooks" value="listBooks"> 
							<input type="hidden" name="userId" value="${userId}"> 
							<input class="smallButton" type="submit" value="My Books">
						</form>
					</div>
				</div>
				
				<br><br>
				<div id="menu" class="dashedBorder">
					<h2 class="centerText">Remove a Listing</h2>
					<div class="dashedBorderContent">
						<form action="bookQuery" method="post">
							<input type="hidden" name="listBooks" value="listBooks"> 
							<input type="hidden" name="userId" value="${userId}"> 
							<input class="smallButton" type="submit" value="Remove Book">
						</form>
					</div>
				</div>
				<br><br>

			</div>
		</div>
	</div>

</body>
</html>