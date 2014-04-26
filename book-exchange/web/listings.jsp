<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<div class="header">
		<a class="homeButton" href="index.jsp">Home</a>

		<div align="right">
		<c:if test="${userId == null}">
			<a class="textAlignRight" href="login.jsp">Login&nbsp</a>
			<a class="textAlignRight" href="signup.jsp">Signup</a>
		</c:if>
</div>

		<c:if test="${userId != null}">
			<div class="textAlignRight" align="right">
				<form action="login" method="post">
					<input type="submit" name="logout" value="Log Out">
				</form>

				<form action="login" method="post">
					<input type="hidden" name="userid" value="${userId}"> <input
						type="hidden" name="userView" value="userView"> <input
						type="submit" name="account" value="My Account">
				</form>
			</div>
		</c:if>

	</div>

	<div class="siteTitlePage">The UGA Book Exchange</div>


	<div class="backPanel">
		<div class="panelContent">
			<h2>Search Results:</h2>

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