<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${book.bookName}</title>
</head>
<body>

	<c:if test="${userId == null}">
			<div id="loginPanel">
				<a class="links" href="login.jsp">Login&nbsp</a> <a class="links"
					href="signup.jsp">Signup</a>
			</div>
		</c:if>
	<div align="right">
		<c:if test="${userId != null}">
			<form action="login" method="post">
				<input type="submit" name="logout" value="Log Out">
			</form>
			<form action="login" method="post">
				<input type="hidden" name="userid" value="${userId}">
				<input type="hidden" name="userView" value="userView">
				<input type="submit" name="account" value="My Account">
			</form>
		</c:if>
	</div>
	<table>
		<tr>
			<td>Title:</td>
			<td>${book.bookName}</td>
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
			<td>$${book.price}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${book.description}</td>
		</tr>
	</table>
	
	<c:if test="${userId == book.uid}">
		<form action="bookQuery" method="post">
			<input type="hidden" name="bid" value="${book.bookId}"> <input
				type="submit" name="removeBook" value="Remove Book">
		</form>
	</c:if>
	<p>
		Poster contact details:<br> Email: 
		<a href="mailto:${book.email}?Subject=Inquiry%20About%20Book:%20${book.bookName}">${book.email}</a>
		Name: ${book.user}
	</p>
</body>
</html>