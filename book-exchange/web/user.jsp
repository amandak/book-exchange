<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User View</title>
</head>
<body>



	<div class="header">
		<a class="homeButton" href="index.jsp">Home</a>
		<div align="right">

				<form action="login" method="post" class="logoutPos">
					<input type="submit" name="logout" value="Log Out">
				</form>

			</div>
	</div>
	<div class="siteTitlePage">The UGA Book Exchange</div>
	<div class="backPanel">
		<div class="panelContent">

			

			<div id="menu" style="float: top;">
				<form action="bookQuery" method="get">
					<input type="hidden" name="listBooks" value="listBooks"> <input
						type="hidden" name="userId" value="${userId}"> <input
						type="submit" value="My Books">
				</form>
				<form action="addBook.jsp" method="post">
					<input type="submit" value="Sell A Book">
				</form>
				<form action="bookQuery" method="post">
					<input type="hidden" name="listBooks" value="listBooks"> <input
						type="hidden" name="userId" value="${userId}"> <input
						type="submit" value="Remove A Book">
				</form>

			</div>
		</div>
	</div>

</body>
</html>