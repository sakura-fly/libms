$(document).ready(function() {

    $("#qk").click(function(event) {
    	$("#ucontent").load("qikanadmin.html");
    });
    $("#books").click(function (e) {
        $("#ucontent").load("bookman.html");
    })
    $("#user").click(function (e) {
        $("#ucontent").load("userman.html");
    })
    $("#qkfx").click(function (e) {
        $("#ucontent").load("qkfx.html");
    })
    $("#booksfx").click(function (e) {
        $("#ucontent").load("bookfx.html");
    })
    $("#booktype").click(function(event) {
        $("#ucontent").load("booktype.html");
    });
    $("#publisheradmin").click(function(event) {
        $("#ucontent").load("publisheradmin.html");
    });
    $("#statmentam").click(function(event) {
        $("#ucontent").load("statement.html");
    });
    $("#newsadmin").click(function(event) {
        $("#ucontent").load("newsadmin.html");
    });

    $("#qk").click();

});