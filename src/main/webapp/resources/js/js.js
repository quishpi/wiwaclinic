$(document).ajaxStop(function() {
    setTimeout(function() {
        $('.ui-messages').slideUp();
    }, 5000);
});