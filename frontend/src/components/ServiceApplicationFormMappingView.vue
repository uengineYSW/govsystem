<template>

    <v-data-table
        :headers="headers"
        :items="serviceApplicationFormMapping"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ServiceApplicationFormMappingView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            serviceApplicationFormMapping : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/serviceApplicationFormMappings'))

            temp.data._embedded.serviceApplicationFormMappings.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.serviceApplicationFormMapping = temp.data._embedded.serviceApplicationFormMappings;
        },
        methods: {
        }
    }
</script>

