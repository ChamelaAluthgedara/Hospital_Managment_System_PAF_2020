<!DOCTYPE html>
<head></head>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="http://localhost:8081/HospitalManagementPAF2020/webapi/doctors">View All Doctors</a>
    <p><a href="http://localhost:8081/HospitalManagementPAF2020/webapi/doctors">Get Single Doctor Details</a>
    
	<form action="http://localhost:8081/HospitalManagementPAF2020/webapi/doctors/doctor/1">
	  <label>DoctorID:</label>
	  <input type="text" id="fname"value="John"><br><br>
	  <input type="submit" value="Submit">
	</form>


    <p><a href="http://localhost:8081/HospitalManagementPAF2020/webapi/doctors">Delete Doctor</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
</body>
</html>
