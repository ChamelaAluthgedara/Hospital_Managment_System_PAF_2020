$(document).ready(function(){
    
    getRegisteredDoctors();
    $("#updateDoctorBtn").hide();
    
//    $("#newTutBtn").on("click", function(e){
//        $("#newForm").toggle();
//    });
//    
    function getRegisteredDoctors(){
        $('#doctorsDetailssBody').html('');
        $.ajax({
            url: 'http://localhost:8081/HospitalManagementPAF2020/webapi/doctors/',
            method: 'get',
            dataType: 'json',
            data: {
                test: 'test data'
            },
            success: function(data) {
                $(data).each(function(i, doctor){
                    $('#doctorsDetailssBody').append($("<tr>")
                                            .append($("<td>").append(doctor.docID))
                                            .append($("<td>").append(doctor.docFName))
                                            .append($("<td>").append(doctor.docLName))
                                            .append($("<td>").append(doctor.docPosition))
                                            .append($("<td>").append(doctor.docFee))
                                            .append($("<td>").append(doctor.docAddress))
                                            .append($("<td>").append(doctor.mobileNo))
                                            .append($("<td>").append(doctor.hosID))
                                            .append($("<td>").append(`
                                                <i class="far fa-edit editTut" data-docid="`+doctor.docID+`"></i> 
                                                <i class="fas fa-trash deleteTut" data-docid="`+doctor.docID+`"></i>
                                            `)));
                    });
                $("#updateForm").hide();
                $("#submitDoctorBtn").show();
                loadButtons();
                }
        });
    }
    
    $("#submitDoctorBtn").on("click", function(e) {
        let data = {
     		   docID: $($("#newForm")[0].docID).val(),
     		   docFname: $($("#newForm")[0].docFname).val(),
     		   docLname: $($("#newForm")[0].docLname).val(),
     		   docPosition: $($("#newForm")[0].docPosition).val(),
     		   docFee: $($("#newForm")[0].docFee).val(),
     		   docAddress: $($("#newForm")[0].docAddress).val(),
     		   mobileNo: $($("#newForm")[0].mobileNo).val(),
     		   hosID: $($("#newForm")[0].hosID).val()
        } 
        
        
         createDoctor(data);
         $("#newForm").trigger("reset");
         e.preventDefault();
        
     });
     
     
     function createDoctor(data) {
         $.ajax({
             url: 'doctorAPI',
             method: 'POST',
             dataType: 'json',
             data: data,
             success: function(data) {
                 console.log(data);
                 getRegisteredDoctors();
             },
         
         });
         getRegisteredDoctors();
     }
     
     function loadButtons() {
         $(".editTut").click(function(e){
             getSingleDoctor($($(this)[0]).data("docid"));
             $("#submitDoctorBtn").hide();
             $("#updateDoctorBtn").show();
             e.preventDefault();
             
         });
         
         $(".deleteTut").click(function(e){
             deleteDoctorDetails($($(this)[0]).data("docid"));
             e.preventDefault();
         })
     }
     
     function getSingleDoctor(id){
         $.ajax({
             url: 'http://localhost:8081/HospitalManagementPAF2020/webapi/doctors/doctor/' + id,
             method: 'get',
             dataType: 'json',
             success: function(data) {
                 $($("#newForm")[0].docID).val(data.docID);
                 $($("#newForm")[0].docFname).val(data.docFName);
                 $($("#newForm")[0].docLname).val(data.docLName);
                 $($("#newForm")[0].docPosition).val(data.docPosition);
                 $($("#newForm")[0].docFee).val(data.docFee);
                 $($("#newForm")[0].docAddress).val(data.docAddress);
                 $($("#newForm")[0].mobileNo).val(data.mobileNo);
                 $($("#newForm")[0].hosID).val(data.hosID);
                 $("#updateForm").show();
                 //$("#newForm").hide();
             }
         });
     }
     
    
     
     function updateDoctorDetails(id, data){
     	console.log(data);
     	 //+ id
         $.ajax({
             url: 'doctorAPI',
             method: 'PUT',
             dataType: 'json',
             data: data,
             success: function( status )
             {
             	 onItemSaveComplete("test", status);
             	 getRegisteredDoctors();
             }
         });
        
     }
     
     function onItemSaveComplete(response, status)
     {
     	console.log("Its done bro " + response, status);
     }

     
     
     $("#updateDoctorBtn").on("click", function(e) {
        let data = {
     		   docID: $($("#newForm")[0].docID).val(),
     		   docFname: $($("#newForm")[0].docFname).val(),
     		   docLname: $($("#newForm")[0].docLname).val(),
     		   docPosition: $($("#newForm")[0].docPosition).val(),
     		   docFee: $($("#newForm")[0].docFee).val(),
     		   docAddress: $($("#newForm")[0].docAddress).val(),
     		   mobileNo: $($("#newForm")[0].mobileNo).val(),
     		   hosID: $($("#newForm")[0].hosID).val()
        } 
        
         updateDoctorDetails($($("#newForm")[0].docID).val(), data);
         $("#newForm").trigger("reset");
         $("#updateDoctorBtn").hide();
         e.preventDefault();
         
        
     });
     
    
});
  



