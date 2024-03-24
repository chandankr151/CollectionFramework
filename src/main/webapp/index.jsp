<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
	<link rel="stylesheet" href="CSS/style11.css">
</head>
<body>
		<div class="divDesign">
			<form id="form1" method="post" action="CrudProg2">
				
				<button id="form1" style="margin-top=10px;">Create Table</button>
			</form>
		</div>
		<div class="divDesign">
			<form id="form2" method="post" action="InsertData">
				<input id="inp1" name="id" placeholder="Enter Id 3digit integer" required>
				<input id="inp2" name="name" placeholder="Enter Name" required>
				<input id="inp3" name="city" placeholder="Enter City" required>
				
				<button id="form2">Insert Record</button>
			</form>
		</div>
		<div class="divDesign">
			<form id="form3" method="post" action="ReadData">
				
				<button id="form3">Display All Record</button>
			</form>
		</div>
		<div class="divDesign">
			<form id="form4" method="post" action="UpdateRecord">
				<input id="inp1" name="id" placeholder="Enter Id 3digit integer" required>
				<input id="inp2" name="name" placeholder="Enter Name" required>
				<input id="inp3" name="city" placeholder="Enter City" required>
				
				<button id="form4">Update Record</button>
			</form>
		</div>
		<div class="divDesign">
			<form id="form5" method="post" action="DeleteRecord">
				<input id="inp1" name="id" placeholder="Enter Id 3digit integer" required>
				
				<button id="form4">Delete Record</button>
			</form>
		</div>
</body>
</html>