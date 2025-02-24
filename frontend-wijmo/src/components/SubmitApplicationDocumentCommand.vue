<template>

    <v-card outlined>
        <v-card-title>
            SubmitApplicationDocument
        </v-card-title>

        <v-card-text>
            <ApplicationFormData offline label="ApplicationFormData" v-model="value.applicationFormData" :editMode="editMode" @change="change"/>
            <String label="ElectronicSignatureData" v-model="value.electronicSignatureData" :editMode="editMode"/>
            <SecurityRating offline label="SecurityRating" v-model="value.securityRating" :editMode="editMode" @change="change"/>
            <ServiceApplicationId offline label="ServiceApplicationId" v-model="value.serviceApplicationId" :editMode="editMode" @change="change"/>
            <FormTemplateId offline label="FormTemplateId" v-model="value.formTemplateId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="submitApplicationDocument"
            >
                SubmitApplicationDocument
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
        name: 'SubmitApplicationDocumentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.applicationFormData = {};
            this.value.electronicSignatureData = '';
            this.value.securityRating = {};
            this.value.serviceApplicationId = {};
            this.value.formTemplateId = {};
        },
        watch: {
        },
        methods: {
            submitApplicationDocument() {
                this.$emit('submitApplicationDocument', this.value);
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

