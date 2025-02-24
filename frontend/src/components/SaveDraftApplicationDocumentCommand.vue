<template>
    <v-card outlined>
        <v-card-title>
            SaveDraftApplicationDocument
        </v-card-title>

        <v-card-text>
            <ApplicationFormData offline label="ApplicationFormData" v-model="value.applicationFormData" :editMode="editMode" @change="change"/>
            <String label="ElectronicSignatureData" v-model="value.electronicSignatureData" :editMode="editMode"/>
            <DraftHistoryRecord offline label="DraftHistoryRecord" v-model="value.draftHistoryRecord" :editMode="editMode" @change="change"/>
            <SecurityRating offline label="SecurityRating" v-model="value.securityRating" :editMode="editMode" @change="change"/>
            <ServiceApplicationId offline label="ServiceApplicationId" v-model="value.serviceApplicationId" :editMode="editMode" @change="change"/>
            <FormTemplateId offline label="FormTemplateId" v-model="value.formTemplateId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="saveDraftApplicationDocument"
            >
                SaveDraftApplicationDocument
            </v-btn>
            
            <v-btn
                    color="primary"
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
        name: 'SaveDraftApplicationDocumentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.applicationFormData = {};
            this.value.electronicSignatureData = '';
            this.value.draftHistoryRecord = {};
            this.value.securityRating = {};
            this.value.serviceApplicationId = {};
            this.value.formTemplateId = {};
        },
        watch: {
        },
        methods: {
            saveDraftApplicationDocument() {
                this.$emit('saveDraftApplicationDocument', this.value);
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

