<template>

    <v-data-table
        :headers="headers"
        :items="issuedDocumentStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'IssuedDocumentStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            issuedDocumentStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/issuedDocumentStatuses'))

            temp.data._embedded.issuedDocumentStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.issuedDocumentStatus = temp.data._embedded.issuedDocumentStatuses;
        },
        methods: {
        }
    }
</script>

