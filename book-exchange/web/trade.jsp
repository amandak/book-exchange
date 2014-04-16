<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Trade a book</title>
	</head>

	<body>
        <form method="post"> 
            Title*:<input type="text" name="username" /><br>
            Author:<input type="text" name="class" /><br>
            Department*:<input type="text" name="department" /><br>
            Class*:<input type="text" name="class" /><br>
            Edition:<input type="text" name="class" /><br>
            Condition:<input type="text" name="class" /><br>
			Description:<br>
			<textarea name="description" rows="3" cols="50"></textarea>
            <input type="submit" value="submit" />
        </form>
		<br>
		* denotes a required field
		<br>
		<a href="index.jsp">home</a>
	</body>
</html>
