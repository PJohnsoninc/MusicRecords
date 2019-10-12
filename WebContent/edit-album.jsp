<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Album</title>
</head>
<style>
	input[type=text], select {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	input[type=submit] {
	  width: 100%;
	  background-color: #3399ff;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border-radius: 4px;
	}
	
	a{
		font-size: 20px;
	}
	
	.box{
		margin: auto;
		width: 50%;
		padding: 10px;
		text-align: center;
	}
</style>
<body>
	<form action = "editAlbumServlet" method = "post">
		Artist: <input type = "text" name = "artist" value = "${albumToEdit.artist}">
		Title: <input type = "text" name = "title" value = "${albumToEdit.title}">
		Year: <input type = "text" name = "year" value = "${albumToEdit.year}">
		<input type = "hidden" name = "id" value = "${albumToEdit.id}">
		<input type = "submit" value = "Save Edited Album">
	</form>
</body>
</html>