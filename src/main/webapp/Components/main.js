$(document).ready(function()
	{
	 $("#alertSuccess").hide();
	 $("#alertError").hide();
	});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear status msges-------------
	 $("#alertSuccess").text("");
	 $("#alertSuccess").hide();
	 $("#alertError").text("");
	 $("#alertError").hide();
	 
	// Form validation----------------
	var status = validateItemForm();
	
	// If not valid-------------------
	if (status != true)
	 {
	 $("#alertError").text(status);
	 $("#alertError").show();
	 
	 return;
 }
	
// If valid----------------------
	var student = getStudentCard($("#txtName").val().trim(),
	 $('input[name="rdoGender"]:checked').val(),
	 $("#ddlYear").val());
	 $("#colStudents").append(student);
	
	 $("#alertSuccess").text("Saved successfully.");
	 $("#alertSuccess").show();
	
	 $("#formDoctor")[0].reset();
	});

// REMOVE==========================================
	$(document).on("click", ".remove", function(event)
	{
	 $(this).closest(".doctor").remove();
	
	 $("#alertSuccess").text("Removed successfully.");
	 $("#alertSuccess").show();
	}); 



// CLIENT-MODEL=================================================================
function validateItemForm()
	{
	
	if ($("#docID").val().trim() == "")
	 {
	 return "Insert Doctor ID.";
	 }
	if ($("#docFname").val().trim() == "")
	 {
	 return "Insert Doctor First Name.";
	 }
	if ($("#docLname").val().trim() == "")
	 {
	 return "Insert Doctor Last Name.";
	 }
	if ($("#docPosition").val().trim() == "")
	 {
	 return "Insert Doctor Position.";
	 }
	if ($("#docFee").val().trim() == "")
	 {
	 return "Insert Doctor Fee.";
	 }
	if ($("#docAddress").val().trim() == "")
	 {
	 return "Insert Doctor Address.";
	 }
	if ($("#docMobile").val().trim() == "")
	 {
	 return "Insert Doctor Mobile Number.";
	 }
	if ($("#docHospitalID").val().trim() == "")
	 {
	 return "Insert Hospital ID.";
	 }
	
	// YEAR
	if ($("#ddlYear").val() == "0")
	 {
	 return "Select year.";
	 }
	return true;
}
function getStudentCard(name, gender, year)
{
	var title = (gender == "Male") ? "Mr." : "Ms.";
	var yearNumber = "";
		switch (year) {
			case "1":
			 yearNumber = "1st";
			 break;
			case "2":
			 yearNumber = "2nd";
			 break;
			case "3":
			 yearNumber = "3rd";
			 break;
			case "4":
			 yearNumber = "4th";
			 break;
		 }
		
	var student = "";
	
	 student += "<div class=\"doctor card bg-light m-2\"style=\"max-width: 10rem; float: left;\">";
	 student += "<div class=\"card-body\">";
	 student += title + " " + name + ",";
	 student += "<br>";
	 student += yearNumber + " year";
	 student += "</div>";
	 student += "<input type=\"button\" value=\"Remove\"class=\"btn btn-danger remove\">";
	 student += "</div>";
	return student;
}








