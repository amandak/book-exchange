<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Book</title>
</head>
<body>
	<h3>Add a Book</h3>

	<form method="post">
		<table>
			<tr><td>Title*:</td>
			<td><input type="text" name="bookTitle" /></td></tr>
			<tr><td>Author:</td>
			<td><input type="text" name="author" /></td></tr>
			<tr><td>ISBN:</td>
			<td><input type="text" name="isbn" /></td></tr>
			<tr><td>Department*:</td>
			<td><input type="text" name="department" /></td></tr>
			<tr><td>Class*:</td>
			<td><input type="text" name="className" /></td></tr>
			<tr><td>Edition:</td>
			<td><input type="text" name="edition" /></td></tr>
			<tr><td>Condition:</td>
			<td><input type="text" name="condition" /></td></tr>
			<tr><td>Price:</td>
			<td><input type="text" name="price" /></td></tr>
			<tr><td>Description:</td>
			<td><textarea name="description" rows="3" cols="50"></textarea></td></tr>
			<tr><td></td><td><input type="submit" value="submit" /></td></tr>
		</table>
	</form>
	<br> * denotes a required field
	<br>
	<a href="index.jsp">home</a>
</body>
</html>