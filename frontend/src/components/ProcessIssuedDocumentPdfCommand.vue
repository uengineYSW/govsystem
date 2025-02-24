<template>
    <v-card outlined>
        <v-card-title>
            ProcessIssuedDocumentPdf
        </v-card-title>

        <v-card-text>
            <Number label="DocumentId" v-model="value.documentId" :editMode="editMode"/>
            <String label="Template" v-model="value.template" :editMode="editMode"/>
            <String label="Font" v-model="value.font" :editMode="editMode"/>
            <Number label="Margin" v-model="value.margin" :editMode="editMode"/>
            <String label="Resolution" v-model="value.resolution" :editMode="editMode"/>
            <String label="EncryptionLevel" v-model="value.encryptionLevel" :editMode="editMode"/>
            <Boolean label="OutputControl" v-model="value.outputControl" :editMode="editMode"/>
            <String label="WatermarkPosition" v-model="value.watermarkPosition" :editMode="editMode"/>
            <String label="SecurityLevel" v-model="value.securityLevel" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="processIssuedDocumentPdf"
            >
                ProcessIssuedDocumentPdf
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
        name: 'ProcessIssuedDocumentPdfCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.documentId = 0;
            this.value.template = '';
            this.value.font = '';
            this.value.margin = 0;
            this.value.resolution = '';
            this.value.encryptionLevel = '';
            this.value.outputControl = false;
            this.value.watermarkPosition = '';
            this.value.securityLevel = '';
        },
        watch: {
        },
        methods: {
            processIssuedDocumentPdf() {
                this.$emit('processIssuedDocumentPdf', this.value);
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

