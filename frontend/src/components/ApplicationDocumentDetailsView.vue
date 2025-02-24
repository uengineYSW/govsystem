<template>

    <v-data-table
        :headers="headers"
        :items="applicationDocumentDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ApplicationDocumentDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            applicationDocumentDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/applicationDocumentDetails'))

            temp.data._embedded.applicationDocumentDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.applicationDocumentDetails = temp.data._embedded.applicationDocumentDetails;
        },
        methods: {
        }
    }
</script>

