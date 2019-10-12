<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Album list</title>
<style>
	table, th, td {
	  border: 1px solid black;
	  margin: auto;
		width: 45%;
		padding: 10px;
		text-align: center;
	}
	
	input[type=submit] {
	  width: 20%;
	  background-color: #3399ff;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border-radius: 4px;
	}
	
	.box{
		margin: auto;
		width: 50%;
		padding: 10px;
		text-align: center;
	}
</style>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<tr>
				<th></th>
				<th>Artist</th>
				<th>Title</th>
				<th>Year</th>
				<th>Date modified</th>
				</tr>
			<c:forEach items="${requestScope.allAlbums}" var = "currentalbum">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentalbum.id}"></td>
					<td>${currentalbum.artist}</td>
					<td>${currentalbum.title}</td>
					<td>${currentalbum.year}</td>
				    <td>${currentalbum.dateCreated}</td>
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name = "doThisToAlbum">
		<input type = "submit" value = "delete" name = "doThisToAlbum">
		<input type = "submit" value = "add" name = "doThisToAlbum">
	</form>
</body>
</html>
