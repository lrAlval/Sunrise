  $(window).load(function() {

    //Just Adding Some Animations With Javascript
       $('#OpenLeftBar').click(function () {
    	   	  $('#CloseLeftBar').addClass('bounceInDown animated');
              $(".PanelUsuario").css("display","");
              $(".PanelUsuario").removeClass("slideOutLeft animated").addClass("slideInLeft animated");
              //Two Main Sections in Left Panel
              $('.MainFolder').animateCss("slideInRight");
              $('.cardinfo').animateCss("slideInRight");
              
       });

       $('#CloseLeftBar').click(function () {
              $('#CloseLeftBar').removeClass('bounceInDown animated');
              $(".PanelUsuario").removeClass("slideInLeft animated").addClass("slideOutLeft animated");
              //Two Main Sections in Left Panel
              $('.MainFolder').animateCss("slideOutRight");
              $('.cardinfo').animateCss("slideOutRight");
       });

       
       
       
       
       
       
       
       

         $(document).mouseup(function (e){
          var container = $(".PanelUsuario");
          // if the target of the click isn't the container...
          // ... nor a descendant of the container
              if (!container.is(e.target)  && container.has(e.target).length === 0) {
                  $('#CloseLeftBar').removeClass('bounceInDown animated');
                  $(".PanelUsuario").removeClass("slideInLeft animated").addClass("slideOutLeft animated");
                 
              }
      });


        /*
          $(document).click (function (e) {
              if (e.target != ($('#OpenLeftBar')[0]  )  ) {
                   $(".PanelUsuario").removeClass("slideInLeft animated").addClass("slideOutLeft animated");
                   $('#CloseLeftBar').removeClass('bounceInDown animated');
              }
          });

        */


    //Later Functionality
    /*
          $(window).scroll(function() {
            var scroll = $(window).scrollTop();
            if (scroll >= 500) {
                //$(".topbarS").addClass('topbarB');
                console.log("add smaller")
            } else {
                //$(".topbarB").removeClass('.topbarB');
                //$(".topbarB").addClass('topbarS');
                console.log("remove smaller")
            }
        });
    */


  var accordionsMenu = $('.cd-accordion-menu');
    if( accordionsMenu.length > 0 ) {
      accordionsMenu.each(function(){
        var accordion = $(this);
        //detect change in the input[type="checkbox"] value
        accordion.on('change', '.UXHandler', function(){
          var checkbox = $(this);
          console.log(checkbox.prop('checked'));
	         
          
          
          ( checkbox.prop('checked') ) ? checkbox.siblings('ul').attr('style', 'display:none;').slideDown(300) : checkbox.siblings('ul').attr('style', 'display:block;').slideUp(300);
        });
      });
    }



   $.fn.extend({
        animateCss: function (animationName) {
            var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            $(this).addClass('animated ' + animationName).one(animationEnd, function() {
                $(this).removeClass('animated ' + animationName);
            });
        }
    });


  });
  
  
  
  
  function closePanel (){
      $('#CloseLeftBar').removeClass('bounceInDown animated');
      $(".PanelUsuario").removeClass("slideInLeft animated").addClass("slideOutLeft animated");
      //Two Main Sections in Left Panel
      $('.MainFolder').animateCss("slideOutRight");
      $('.cardinfo').animateCss("slideOutRight");
      return true;
  }


