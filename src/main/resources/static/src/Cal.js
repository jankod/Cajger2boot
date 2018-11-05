const defaultConf = {
    defaultView: 'timelineDay',
    editable: true,
    eventSources: [
        {
            url: '/cal/events'
        }
    ],
    header: {
        left: 'promptResource today prev,next',
        center: 'title',
        right: 'timelineDay,timelineThreeDays,agendaWeek,month'
    },
    customButtons: {
        promptResource: {
            text: 'room 8 :) ',
            click: function () {
                $('#calendar').fullCalendar(
                    'addResource',
                    {title: 'Novo 1'},
                    true // scroll to the new resources?
                );
            }
        }
    },
    schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source',
    resourceLabelText: 'Sobe',
    resourceRender: function (resource, cell) {
        // console.log(cell);
        // cell.html( 'Ovo je ook <b> evo</b>');
        cell.on('click', function () {
            if (confirm('Are you sure you want to delete ' + resource.title + '?')) {
                $('#calendar').fullCalendar('removeResource', resource);
            }
        });
    },

    resources: {
        url: '/cal/resources',
        error: function (err) {
            console.error(err)
            alert("error got " + err)
            //$('#script-warning').show();
        }
    }

    // resources: [
    //     {id: 'a', title: 'Room AA'},
    //     {id: '2', title: 'Room B'},
    //     {id: 'c', title: 'Room C'},
    //     {id: 'd', title: 'Room D'}
    // ]
};
export default class Cal {

    constructor(id) {
        this.id = id;
    }

    show() {
        $('#' + this.id).fullCalendar(defaultConf);
    }
}