<template>

    <v-data-table
        :headers="headers"
        :items="externalDataQueryHistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ExternalDataQueryHistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            externalDataQueryHistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/externalDataQueryHistories'))

            temp.data._embedded.externalDataQueryHistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.externalDataQueryHistory = temp.data._embedded.externalDataQueryHistories;
        },
        methods: {
        }
    }
</script>

