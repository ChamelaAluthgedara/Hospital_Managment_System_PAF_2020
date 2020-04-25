<%@page import="doctorController.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

<title>Docotor Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Doctor Management</h1>
				
				<form id="formDoctor" name="formDoctor">
				
					Doctor ID: <input id="docID" name="docID" type="text"
						class="form-control form-control-sm"> <br>
				
					
					Doctor Firstname: <input id="docFname" name="docFname" type="text"
						class="form-control form-control-sm"> <br>
						
						
					Doctor Lastname:<input id="docLname" name="docLname" type="text"
						class="form-control form-control-sm"> <br> 
						
						
					Doctor Position:<input id="docPosition" name="docPosition" type="text"
						class="form-control form-control-sm"> <br> 


					Doctor Fee:<input id="docFee" name="docFee" type="text"
						class="form-control form-control-sm"> <br> 						


					Doctor Address:<input id="docAddress" name="docAddress" type="text"
						class="form-control form-control-sm"> <br> 


					Doctor Mobile No:<input id="docMobile" name="docMobile" type="text"
						class="form-control form-control-sm"> <br> 
						

					Hospital ID:<input id="docHospitalID" name="docHospitalID" type="text"
						class="form-control form-control-sm"> <br> 
						
												
				 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> <input type="hidden"
						id="hidItemIDSave" name="hidItemIDSave" value="">
						
				</form>
				
				<br><br><br>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<!--  <div id="divDoctorGrid">
					//<%
					//	Doctor itemObj = new Doctor();
					//out.print(itemObj.readItems());
					//%>
					-->
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>

