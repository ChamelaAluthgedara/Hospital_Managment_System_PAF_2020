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
    
 
    
});
  



