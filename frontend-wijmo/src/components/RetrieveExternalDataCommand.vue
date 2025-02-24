<template>

    <v-card outlined>
        <v-card-title>
            RetrieveExternalData
        </v-card-title>

        <v-card-text>
            <String label="CollectionId" v-model="value.collectionId" :editMode="editMode"/>
            <String label="SystemName" v-model="value.systemName" :editMode="editMode"/>
            <String label="QueryItems" v-model="value.queryItems" :editMode="editMode"/>
            <String label="QueryPeriod" v-model="value.queryPeriod" :editMode="editMode"/>
            <Number label="Priority" v-model="value.priority" :editMode="editMode"/>
            <String label="DataProcessingRules" v-model="value.dataProcessingRules" :editMode="editMode"/>
            <IntegrationDetails offline label="IntegrationDetails" v-model="value.integrationDetails" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="retrieveExternalData"
            >
                RetrieveExternalData
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RetrieveExternalDataCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.collectionId = '';
            this.value.systemName = '';
            this.value.queryItems = '';
            this.value.queryPeriod = '';
            this.value.priority = 0;
            this.value.dataProcessingRules = '';
            this.value.integrationDetails = {};
        },
        watch: {
        },
        methods: {
            retrieveExternalData() {
                this.$emit('retrieveExternalData', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

