function complex(e){
e = e || window.event;
e = e.target || e.srcElement;
// alert(e.id);
// alert($("#service1").attr("name"));
 }
function simple(){
 //alert("here12");
 //alert($("#service1").attr("name"));
 }



$(window).load(function() {
    $('#loading').hide();
  });

//BEGIN: document ready
$(document).ready(function(){
	
	$( "form" ).submit(function() {
		//alert("Form Submitting11");
	    $('#loading').show();
	    
	    return ;
	});
	
$(".atag").on('click',function(){
$(this).siblings("div").toggleClass("collapse");
});

$(".btag").on('click',function(){
value1 = $(this).attr("data1");
value2 =$(this).attr("data2");
$("#svcNM").val(value1);
$("#oprNM").val(value2);
//alert($("#svcNM").val());
//alert($("#oprNM").val());
//ajax: call begin
$.ajaxSetup ({
    cache: false
});
var ajax_load = "<img src='images/loading3.gif' alt='loading...' />";
var loadUrl = "operation.htm";
$("#rightPanel").html(ajax_load).load(loadUrl,{svcNM: value1,oprNM: value2});
});
//END: b-tag click

});
//END: document ready

//BEGIN: document.on.click saveResp
$(document).on("click",".saveResp",function(){
	respVal = $("#defaultResponse").val();
	$.ajaxSetup ({
	    cache: false
	});
	var ajax_load = "<img src='images/ajax-loader.gif' alt='loading...' />";
	var destURL ="saveDefResp.htm";
	$("#ajaxLoad").html(ajax_load).load(destURL,{defResp:respVal,selectedSvc:$("#svcNM").val(),selectedOpr:$("#oprNM").val()});
	});
//END:saveResp click

//BEGIN: document.on.click ctag
$(document).on('click',"#ctag",function(){
	$('#content1').toggleClass("collapse");
	$('#content2').toggleClass("collapse");
	$('#content2').animate({height:"90%",width: "90%"},100);
	
	//ajax: call begin
	$.ajaxSetup ({
	    cache: false
	});
	var ajax_load = "<img src='images/loading3.gif' alt='loading...' />";
	var loadUrl = "customResponse.htm";
	$('#content2').html(ajax_load).load(loadUrl,{svcNM: $("#svcNM").val(),oprNM: $("#oprNM").val()});
});	
//END: c-tag click

//BEGIN:main-menu click
$(document).on('click',"#mainMenu",function(){
	$('#content1').toggleClass("collapse");
	$('#content2').toggleClass("collapse");
});
//END: main-menu click

//BEGIN: document.on.click saveCustomResp
$(document).on('click',"#saveCustomResp",function(){
	var resval = $("#customResponse").val();
	$.ajaxSetup ({
	    cache: false
	});
	var ajax_load = "<img src='images/ajax-loader.gif' alt='loading...' />";
	var destURL ="saveCustomResp.htm";
	$("#ajaxLoadCustomResp").html(ajax_load).load(destURL,{elementName:$("#keyElementVal").val(),elementValue:$("#customVal").val(),customResp:resval,selectedSvc:$("#svcNM").val(),selectedOpr:$("#oprNM").val()});
});
//END: saveCustomResp click

//BEGIN: document.on.click showSavedHistory
$(document).on('click',"#showSavedHistory",function(){
	$('#content3').toggleClass("collapse");
	$.ajaxSetup ({
	    cache: false
	});
	var ajax_load = "<img src='images/ajax-loader.gif' alt='loading...' />";
	var destURL ="showSavedHistory.htm";
	$("#content3").html(ajax_load).load(destURL,{selectedSvc:$("#svcNM").val(),selectedOpr:$("#oprNM").val()});
});
//END: showSavedHistory click

//BEGIN: document.on.click closeList
$(document).on('click',"#closeList",function(){
	$('#content3').toggleClass("collapse");	
});
//END: closeList  click