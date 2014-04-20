<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Results</title>
	</head>
	<body>
		
		<!--  TODO - Add dynamic functionality to this JSP page -->
		
		<!--  c:foreach -->
		<table>
			<tr><th>Title</th><th>Author</th><th>Department</th><th>Class</th><th>Price</th><th>Condition</th></tr>
			<tr>
				<td><a href="bookQuery?bookId=${book.bookId}">Java Servlets and JSP</a></td>
				<td>Murach</td>
				<td>CSCI</td>
				<td>3030</td>
				<td>$20.00</td>
				<td>acceptable</td>
			</tr>
		</table><br>
		<a href="index.jsp">home</a>
	
	</body>
</html>