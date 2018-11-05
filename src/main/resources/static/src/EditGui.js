const axios = require('axios');
export default class EditGui {


    constructor() {

    }

    init() {

        let btn = $("#btnAddResource");
        btn.on('click', () => {
            this.showAddResource();
        })

    }

    showAddResource() {
        let resourceName = prompt("Enter new resource:");
        if (resourceName != null) {

            axios.post('/cal/resources', {
                name: resourceName
            })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
            console.log(resourceName);
        }
    }
};