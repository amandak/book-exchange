<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User View</title>
</head>
<body>



	<div id="header">
		<h1 style="margin-bottom: 0;">UGA BookExchange</h1>

		<div align="right">

			<form action="login" method="post">
				<input type="submit" name="logout" value="Log Out">
			</form>

		</div>
	</div>
	<div id="menu"
		style="float:top;">
		<form action="bookQuery" method="get">
			<input type="hidden"  name="listBooks" value="listBooks">
			<input type="hidden" name="userId" value="${userId}">
			<input type="submit" value="My Books">
		</form>
		<form action="addBook.jsp" method="post">
			<input type="submit" value="Sell A Book">
		</form>
		<form action="bookQuery" method="post">
			<input type="hidden"  name="listBooks" value="listBooks">
			<input type="hidden" name="userId" value="${userId}">
			<input type="submit" value="Remove A Book">
		</form>
		
	</div>

	<div id="content"
		style="float: left;">
		Content goes here</div>

	


</body>
</html>