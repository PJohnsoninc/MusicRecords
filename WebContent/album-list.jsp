<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Album list</title>
<link href="tables.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<tr>
				<th></th>
				<th>Artist</th>
				<th>Artist_Description</th>
				<th>Title</th>
				<th>Genre</th>
				<th>Genre_Description</th>
				<th>Year</th>
				<th>Date_Modified</th>
				</tr>
			<c:forEach items="${requestScope.allAlbums}" var = "currentalbum">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentalbum.album_id}"></td>
					<td>${currentalbum.artist.name}</td>
					<td>${currentalbum.artist.description}</td>
					<td>${currentalbum.title}</td>
					<td>${currentalbum.genres.name}</td>
					<td>${currentalbum.genres.description}</td>
					<td>${currentalbum.year}</td>
				    <td>${currentalbum.createdOn}</td>
				    
				</tr>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name = "doThisToAlbum">
		<input type = "submit" value = "delete" name = "doThisToAlbum">
		<input type = "submit" value = "add" name = "doThisToAlbum">
	</form>
</body>
</html>
