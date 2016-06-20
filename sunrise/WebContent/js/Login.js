$(document).ready(function() {
    //Just Loading the JSP in the iframe , for speed purposes
    //$(".MainBody"); 
	
	/*
	
    $("#log").submit(function(e) {

        //prevent Default functionality
        e.preventDefault();

        //get the action-url of the form
        //var actionurl = e.currentTarget.action;

        //do your own request an handle the results
        $.ajax({
            url: "CLogin",
            type: 'POST',
            dataType: 'json',
            data: $("#log").serialize(),
            success: function(response) {
            	 if(response.Error !== undefined){
                 	sweetAlert("Oops...", response.Error, "error");
                 }else{
                     window.location.assign(response.url);
                 }
            }
        });

    });
    
    */
	

	
	
	
	
    $('select').selectpicker({
        style: 'btn-primary',
        size: false
    });



    $("#ShowForgot").click(function(e) {
        $(".WrapperForgot").css("display", "");
        $(".WrapperForgot").animateCss("zoomIn");
        $(".WrapperLogin").css("display", "none");
    });

    $("#ShowLogin").click(function(e) {
        $(".WrapperLogin").css("display", "");
        $(".WrapperLogin").animateCss("zoomIn");
        $(".WrapperForgot").css("display", "none");
    });



    $.fn.extend({
        animateCss: function(animationName) {
            var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            $(this).addClass('animated ' + animationName).one(animationEnd, function() {
                $(this).removeClass('animated ' + animationName);
            });
        }
    });










});
