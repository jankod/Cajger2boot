require('moment');
require('fullcalendar');
require('fullcalendar-scheduler');
require('fullcalendar/dist/locale/hr');
require('./fullcalendar.scss');

// ###
// require('./Cal');
import Cal from './Cal';
import EditGui from './EditGui';


require('./index.scss');


$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });


    let cal = new Cal('calendar');
    cal.show();
    //debugger;
    new EditGui().init();
    //$('#calendar').fullCalendar(defaultConf);


});

console.log("calendar 2");