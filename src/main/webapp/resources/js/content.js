/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/21/13
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */
$(function() {

    $( ".calendarTgl" ).datepicker({ dateFormat: "dd-mm-yy", changeMonth:true, changeYear:true });
    $(".tglFT").datepicker("setDate", new Date);


    $( "#from" ).datepicker({
        defaultDate: "+1w",
        dateFormat:"dd-M-yy",
        changeYear:true,
        changeMonth:true,

        onClose: function( selectedDate ) {
            $( "#to" ).datepicker( "option", "minDate", selectedDate );
        }
    });
    $( "#to" ).datepicker({
        defaultDate: "+1w",
        dateFormat:"dd-M-yy",
        changeYear:true,
        changeMonth:true,

        onClose: function( selectedDate ) {
            $( "#from" ).datepicker( "option", "maxDate", selectedDate );
        }
    });
    $( "#tabs" ).tabs({
        beforeLoad: function( event, ui ) {
            ui.jqXHR.error(function() {
                ui.panel.html(
                    "Couldn't load this tab. We'll try to fix this as soon as possible. " +
                        "If this wouldn't be a demo." );
            });
        }
    });

});
function popitup(url, w,h) {
    var left =(screen.width/2)-(w/2);
    var top=(screen.height/2)-(h/2);
    newwindow=window.open(url,'name','height='+w+',width='+h+', top='+top+', left='+left);
    if (window.focus) {newwindow.focus()}
    return false;
}
