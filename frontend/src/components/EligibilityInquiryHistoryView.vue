<template>

    <v-data-table
        :headers="headers"
        :items="eligibilityInquiryHistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'EligibilityInquiryHistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            eligibilityInquiryHistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/eligibilityInquiryHistories'))

            temp.data._embedded.eligibilityInquiryHistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.eligibilityInquiryHistory = temp.data._embedded.eligibilityInquiryHistories;
        },
        methods: {
        }
    }
</script>

