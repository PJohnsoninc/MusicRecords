<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Album</title>
</head>
<link href="forms.css" rel="stylesheet" type="text/css">
<body>
	<form action = "editAlbumServlet" method = "post">
		Artist: <input type = "text" name = "artist_name" value = "${albumToEdit.artist.name}">
		Artist_Description: <input type = "text" name= "artist_description" value = "${albumToEdit.artist.description}">
		Title: <input type = "text" name = "title" value = "${albumToEdit.title}">
		Genre: <input type = "text" name = "genre_name" value = "${albumToEdit.genres.name}">
		Genre_Description: <input type = "text" name = "genre_description" value = "${albumToEdit.genres.description}">
		Year: <input type = "text" name = "year" value = "${albumToEdit.year}">
		<input type = "hidden" name = "id" value = "${albumToEdit.album_id}">
		<input type = "submit" value = "Save Edited Album">
	</form>
</body>
</html>