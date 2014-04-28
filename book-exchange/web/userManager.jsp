<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>
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
			<h2>Users:</h2>

				<form method="post" action="manager">
				<table>
						<th>UID</th>
						<th>Username</th>
						<th>Email</th>
						<th>Name</th>
						<th>Address</th>
						<th>Remove User</th>
			<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.userId}</td>
						<td>${user.userName}</td>
						<td>${user.emailAddress}</td>
						<td>${user.firstName} ${user.lastName}</td>
						<c:if test="${user.zip > 0}">
						<td>${user.streetAddress} ${user.city}, ${user.state} ${user.zip}</td>
						</c:if>
						<c:if test="${user.zip < 0}">
						<td>
						</td>
						</c:if>
						<td>
							<input type="checkbox" name="remUser" value="${user.userId}">
						</td>
					</tr>
			</c:forEach>
				</table>
				<input type="submit" value="Remove Selected Users" />
				</form>


		</div>
	</div>

</body>
</html>
