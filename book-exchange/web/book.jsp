<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Java Servlets and JSP</title>
	</head>
	<body>
	
	<div align="right">
			<c:if test="${userId != null}">
				<form action="login" method="post">
					<input type="submit" name="logout" value="Log Out">
				</form>
			</c:if>
		</div>
		<table>
		<tr><td>Title:</td><td>${book.bookName}</td></tr>
		<tr><td>Author:</td><td>${book.author}</td></tr>
		<tr><td>Edition:</td><td>${book.edition}</td></tr>
		<tr><td>ISBN:</td><td>${book.isbn}</td></tr>
		<tr><td>Class:</td><td>${book.classTitle}</td></tr>
		<tr><td>Condition:</td><td>${book.condition}</td></tr>
		<tr><td>Price:</td><td>$${book.price}</td></tr>
		<tr><td>Description:</td><td>${book.description}</td></tr>
		</table>

		<p>Poster contact details:<br>
		Email: <a href="mailto:${book.email}?Subject=Inquiry%20About%20Book:%20${book.bookName}">${book.email}</a>
		Name: ${book.user}
		</p>
	</body>
</html>