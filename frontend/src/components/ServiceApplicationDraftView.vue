<template>

    <v-data-table
        :headers="headers"
        :items="serviceApplicationDraft"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ServiceApplicationDraftView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            serviceApplicationDraft : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/serviceApplicationDrafts'))

            temp.data._embedded.serviceApplicationDrafts.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.serviceApplicationDraft = temp.data._embedded.serviceApplicationDrafts;
        },
        methods: {
        }
    }
</script>

