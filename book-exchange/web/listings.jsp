<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Listings</title>
</head>
<body>
	<div class="header">
			<a class="homeButton" href="index.jsp">Home</a>
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

	<div class="siteTitlePage">The UGA Book Exchange</div>


	<div class="backPanel">
		<div class="panelContent">
			<h2>Book Listings:</h2>

			<c:forEach items="${bookList}" var="book">
				<table>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Department</th>
						<th>Class</th>
						<th>Price</th>
						<th>Condition</th>
					</tr>
					<tr>
						<td><a class="bookTableLink"
							href="bookQuery?bookId=${book.bookId}">${book.bookName}</a></td>
						<td>${book.author}</td>
						<td>${book.department }</td>
						<td>${book.classTitle}</td>
						<td>$${book.price}</td>
						<td>${book.condition}</td>
					</tr>
				</table>
			</c:forEach>

		</div>
	</div>

</body>
</html>