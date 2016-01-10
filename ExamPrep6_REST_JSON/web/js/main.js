$(window).ready(init);

function init(){
    $("#populate").click(populate);
};

function populate(){
    var $table = $("table");
    var $inputN = $("#n");
    var $inputT = $("#type");
    
    var n = $inputN.val();
    var t = $inputT.val();
    
    $.ajax({
        url: "api/addresses/" + n + "/" + t,
        success: function (data, textStatus, jqXHR) {
            $table.html('<tr><th>n</th><th>fName</th><th>lName</th><th>Street</th><th>City</th></tr>');
            $.each(data, function (i, person){
                $table.append("<tr><td>" + i + "</td><td>" + person.fName + "</td><td>" + person.lName 
                        + "</td><td>" + person.street + "</td><td>" + person.city + "</td></tr>");
            });
        }
    });
};