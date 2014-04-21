<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Results</title>
	</head>
	<body>
		
		<!--  TODO - Add dynamic functionality to this JSP page -->
		<p style="color:red">${errorFind}</p>
		<c:forEach items="${bookList}" var="book">
		<table>
			<tr><th>Title</th><th>Author</th><th>Department</th><th>Class</th><th>Price</th><th>Condition</th></tr>
			<tr>
				<td><a href="bookQuery?bookId=${book.bookId}">${book.bookName}</a></td>
				<td>${book.author}</td>
				<td>${book.department }</td>
				<td>${book.classTitle}</td>
				<td>$${book.price}</td>
				<td>${book.condition}</td>
			</tr>
		</table>
		</c:forEach>
		<br>
		<a href="index.jsp">home</a>
	
	</body>
</html>