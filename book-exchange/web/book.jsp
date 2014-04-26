<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${book.bookName}</title>
	</head>
	<body>

			<div class="header"><a class="homeButton" href="index.jsp">Home</a>
				<c:if test="${userId == null}">
					<div class="homeButton">
						<a class="links" href="login.jsp">Login&nbsp</a> 
						<a class="links" href="signup.jsp">Signup</a>
					</div>
				</c:if>
					
				<c:if test="${userId != null}">
					<div class="homeButton" align="right">
						<form action="login" method="post" class="logoutPos">
						<input type="submit" name="logout" value="Log Out">
						</form>
		
						<form action="login" method="post" class="myAccountPos">
						<input type="hidden" name="userid" value="${userId}">
						<input type="hidden" name="userView" value="userView">
						<input type="submit" name="account" value="My Account">
						</form>
					</div>
				</c:if>		
			</div>

				
			<div class="siteTitlePage">The UGA Book Exchange</div>
		
		<div class="backPanel">
			<div class="panelContent">
			
	<table>
		<tr>
			<td><h3>Title:</h3></td>
			<td><h3>${book.bookName}</h3></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td>Edition:</td>
			<td>${book.edition}</td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<td>Class:</td>
			<td>${book.classTitle}</td>
		</tr>
		<tr>
			<td>Condition:</td>
			<td>${book.condition}</td>
		</tr>
		<tr>
			<td>Price:</td>
			<td>${book.price}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${book.description}</td>
		</tr>
	</table>
	<br><br><br>
		
	<p>
		<h3>Seller Contact Information:</h3><br>
		Name: ${book.user} <br>
		Email: <a href="mailto:${book.email}?Subject=Inquiry%20About%20Book:%20${book.bookName}">${book.email}</a>
	</p>
	<br><br>
	
	<c:if test="${userId == book.uid}">
		<form action="bookQuery" method="post">
			<input type="hidden" name="bid" value="${book.bookId}"> 
			<input class="submitButton" type="submit" name="removeBook" value="Remove Listing">
		</form>
	</c:if>
	 
	
	
		</div>
	</div>
</body>
</html>