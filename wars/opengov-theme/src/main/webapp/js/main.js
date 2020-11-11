AUI().ready(
	'liferay-sign-in-modal',
	function(A) {
		var signIn = A.one('.sign-in > a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
		
		$('.close-modal').on('click', function() { 
			$('.modal').modal('hide');
		});
		
		if (!Liferay.ThemeDisplay.isSignedIn() ) $("fieldset.add-comment").css("display", "none");
	}
);

jQuery(document).ready(function() {
	
	$("#logout-link").click(function(e) {
		//e.preventDefault();
		AUI().use('aui-base', 'aui-io-request', 'liferay-form', 'aui-alert', function(A) {
//						  /consulta?p_p_id=AmaLogin&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_AmaLogin_mvcRenderCommandName=viewLogout
			A.io.request('/consulta?p_p_id=AmaLogin&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_AmaLogin_mvcRenderCommandName=viewLogout', {
			 dataType: 'json',
			 method: 'POST',
			 on: {
					success: function() {
						console.log("logged out");
//						$.post( "/c/portal/logout", function( ) {
//							location.reload();
//							console.log("portal logout!");
//						});
			 		},
			 		failure: function() {
			 			return false;
			 		}
			 	}
			 });
			
		});	
	});

	$("#hrefFm").append('<input type="submit" style="display:none" />');
	
	$( ".btn-search-go" ).click(function() {
	  $( ".search-navbar form" ).submit();
	});	
	
	if(window.location.href.indexOf("p_p_id=com_liferay_portal_search_web_portlet_SearchPortlet") > -1) {
		$( ".search-wrapper" ).hide();
		
		$("#_com_liferay_portal_search_web_portlet_SearchPortlet_searchSearchContainer").find("a").each(function() { 
			var x = $(this).attr("href").split("?")[0]; 
			$(this).attr("href", x ); 
		});		
		
		$("a").click(function(e) {
			e.preventDefault();
			//console.log("Prevent");
			location.href = $(this).attr('href');
		});
    }
	
		
	$("#myModalSuggestion .form-group textarea").each(function() {		
		$(this).keyup(function() {			
			var count = this.value.length;
			var length = $(this).attr("maxlength") - count;			
			$(this).next().next().find("span").text(length);
		});
	});
    
    var maxLength_2 = 500;
    $('#myModal textarea').keyup(function() {
    	var count = $(this).length;
    	var length = maxLength_2 - count;
    	$('#myModal #chars').text(length);
    });
    
    if ($("#counter").length > 0) {
	    var date1=new Date(new Date().toISOString().substring(0, 10));
	    var date2=new Date(2017, 11, 13);
	    var daysDiff = days_between(date1, date2);
	    $("#counter-days1").data().count = daysDiff;
	    
	    var date3=new Date(2018, 11, 3);
	    var daysDiff2 = days_between(date1, date3);
	    $("#counter-days2").data().count = daysDiff2;
    }
    
    var counterAlreadyRun = false;
    var counterAlreadyStarted = false;
    var isMobile = /android|webos|iphone|ipad|ipod|blackberry|iemobile|opera mini/i.test(navigator.userAgent.toLowerCase());
	
	$(window).scroll(function() {
		if (counterAlreadyStarted || counterAlreadyRun) return;
		if ($("#counter").isOnScreen()) {			
			startCounterAnimation();
		}
	});
		
	if ($("#counter").length > 0) {
		if ($("#counter").isOnScreen()) {			
			if (counterAlreadyStarted || counterAlreadyRun) return;
			 	startCounterAnimation();
		}
	}
	
	if (isMobile) {   
	    $("#counter-days1").text(daysDiff);
	    $("#counter-days2").text(daysDiff2);
	}
	
	/* Start Comment submission */
	
	$('#addCommentForm').validator().on('submit', function (e) {
		if (e.isDefaultPrevented()) {
		  console.log("Tem Erros! addComment ");
	  } else {
		  e.preventDefault();
		  console.log("Não tem Erros! addComment");		  
		  grecaptcha.reset();
		  grecaptcha.execute();
		  showCommentLoader();
	  }
	});
	/* End Comment */
	
	function showCommentLoader() {
	    var $this = $(this);
	    document.getElementById("loader").style.display = "inline-flex";
	    setTimeout(function() {
	    	setTimeout($("#loader").css("display", "none") , 3000);
	    		//$this.button('reset');
	    	}, 3000);
	}
	
	/* Add Web Content */	
//	$('#propose-measure').validator().on('submit', function (e) {
//		  if (e.isDefaultPrevented()) {
//			  console.log("Tem Erros propose-measure! ");
//		  } else {
//			  console.log("Não tem Erros propose-measure! ");
////			  e.preventDefault();
//			  proposeMeasureSubmit();
//		  }
//	});
	/* End Web Content Submit */
	
	$(".close-search").hide();
	$(".search-icon").click(function(){
        $(".search-navbar").slideDown();
        $( this ).fadeTo( "fast" , 0, function() {
        	$(this).hide();
        	$( ".close-search" ).fadeTo( "slow", 1 );
	    	$( ".close-search" ).css( "z-index", "1" );
	    });
        $( this ).css( "z-index", "0" );       
    });
	
	$(".close-search").click(function(){
        $(".search-navbar").slideUp();
        
        $( this ).fadeTo( "fast" , 0, function() {
        	$(this).hide();
        	$( ".search-icon" ).fadeTo( "slow", 1 );
	    	$( ".search-icon" ).css( "z-index", "1" );
	    });
        
        $( this ).css( "z-index", "0" );
       
    });	
	
	$('.navbar-right').attr('id', 'navbar-right');
	$(".toTop i").removeClass('icon-angle-up');
	$(".toTop i").addClass('icon-angle-down');	
});


function startCounterAnimation() {
	if (!$("#counter").isOnScreen()) return;
	//console.log("Already Started = "+counterAlreadyStarted);
	//counterAlreadyStarted = true;
    $('.counter-value').each(function() {
    	var $this = $(this);
    	if ($this.text() > 0) return;
	    //$this.attr('data-count', daysDiff);
      $({
        countNum: $this.text()
      }).animate({
          countNum: $this.data().count //daysDiff //countTo
        },

        {
          duration: 4000,
          easing: 'swing',
          step: function() {
            $this.text(Math.floor(this.countNum));
          },
          complete: function() {
            $this.text(this.countNum);
            //console.log("counterAlreadyRun="+counterAlreadyRun);
            counterAlreadyRun = true;
          }

        });
      	counterAlreadyRun = true;
    });
}

function days_between(date1, date2) {
    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24

    // Convert both dates to milliseconds
    var date1_ms = date1.getTime()
    var date2_ms = date2.getTime()

    // Calculate the difference in milliseconds
    var difference_ms = Math.abs(date1_ms - date2_ms)

    // Convert back to days and return
    return Math.round(difference_ms/ONE_DAY)
}

function proposeMeasureSubmit() {
	var nome		= $('#pm-nome').val();
	var titulo		= $('#pm-titulo').val();		
	var eixos		= $('#pm-eixos').val();
	var objectivo	= $('#pm-objectivo').val();
	var problema	= $('#pm-problema').val();
	var solucao		= $('#pm-solucao').val();
	var outras		= $('#pm-outras').val();

	console.log("Nome="+nome);
	var data = {};	
	data["nome"]=nome;
	data["titulo"]=titulo;
	data["eixos"]=eixos;
	
	data["objectivo"]=objectivo;
	data["problema"]=problema;
	data["solucao"]=solucao;
	data["outras"]=outras;
	
	console.log(data["eixos"]);
	var dataJson = JSON.stringify(data);
	console.log("Data JSON proposta="+dataJson);
	submitData(dataJson);
	return false;		
}

function submitData(dataJson){
	 
 	AUI().use('aui-base','aui-io-request','liferay-form','aui-alert', function(A){

		var portletUrl = "AMA_OpenGov_portlet_insertContentPortlet";
		A.io.request('/addcomment?p_p_id='+portletUrl+'&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=addcomment&p_p_cacheability=cacheLevelPage', {
			 dataType: 'json',
			 method: 'POST',
			 data:   { data: dataJson }  ,
			 on: {
				success: function() {
				 	var data=this.get('responseData');
					 
					var name = data.nome;	
					var error = data.error;
					console.log("error"+error);
					$("#propose-measure").hide();
					$("#pm-nome").val("");
					$("#pm-email").val("");
					$("#pm-mensagem").val("");
					$("#pm-titulo").val("");
					$("#pm-eixos").val("");
					$('#pm-objectivo').val("");
					$('#pm-problema').val("");
					$('#pm-solucao').val("");
					$('#pm-outras').val("");
					$('#pm-nome').val(Liferay.ThemeDisplay.getUserName());
					console.log("error"+error);
					
					var uri = window.location.toString();
					console.log(uri);
					if (uri.indexOf("?") > 0) {
						console.log("If uri");
					    var clean_uri = uri.substring(0, uri.indexOf("?"));
					    console.log(clean_uri);
					    window.history.replaceState({}, document.title, clean_uri);
					}
					
					if(error === false){
						console.log("if");
						$("#myModalSuggestion").find(".alert-success").fadeIn();
					} else {
						console.log("else");
						$("#myModalSuggestion").find(".alert-danger").fadeIn();
					}
		 		},
		 	}
		 });
	});
}

function mySubmit() {	
	var nome=$("#addCommentForm").find("#nome").val();
	var email=$("#addCommentForm").find("#email").val();
	var msg=$("#addCommentForm").find("#msg").val();
	
	var data = {};	
	data["nome"]=nome;
	data["email"]=email;
	data["msg"]=msg;
	var dataJson = JSON.stringify(data);
	console.log("Data JSON="+dataJson)
	submitCommentData(dataJson);
	return false;	
}

function submitCommentData(dataJson){
	AUI().use('aui-base','aui-io-request','liferay-form','aui-alert', function(A){
		 var portletUrl = "AMA_OpenGov_portlet_ProcessCommentPortlet";
		 
		 A.io.request('/addcomment?p_p_id='+portletUrl+'&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=addComment&p_p_cacheability=cacheLevelPage', {
			 dataType: 'json',
			 method: 'POST',
			 data: { data: dataJson },
			 on: {
				success: function() {
					
				 	var data=this.get('responseData');
				 	var msg = data.message;
					var name = data.nome;	
					var error = data.error;
					console.log(nome +" - "+ msg +" Erro="+error);
					
					$("#addCommentForm").hide();
					$("#addCommentForm").find("#nome").val("");
					$("#addCommentForm").find("#email").val("");
					$("#addCommentForm").find("#msg").val("");
					
					if(error === false){
						$("#myModal").find(".alert-success").fadeIn();
					} else {
						$("#myModal").find(".alert-danger").fadeIn();
					}
		 		},
		 	}
		 });
	});
}

$('#myModal').on('hidden.bs.modal', function (e) {
	$("#myModal").find(".alert").hide();
	$("#addCommentForm").show();	
});

$('#myModalSuggestion').on('hidden.bs.modal', function (e) {
	console.log("hidden.bs.modal func");
	$("#myModalSuggestion").find(".alert").hide();
	console.log("alert hide");
	$("#propose-measure").show();
	console.log("propose-measure show");
	var uri = window.location.toString();
	if (uri.indexOf("?") > 0) {
	    var clean_uri = uri.substring(0, uri.indexOf("?"));
	    window.history.replaceState({}, document.title, clean_uri);
	}
});

$(".navbar-toggle").click(function() { 
    document.getElementById("menu-wrapper").style.right = "0";
});

$(".close").click(function() { 
    document.getElementById("menu-wrapper").style.right = "-100%";    
});

$(window).resize(function(){	
	if ($(window).width() > 768) {
		   $("#mobile-menu").hide();
	} else {
		$("#mobile-menu").show();
	}	
});

/**/