<template>
    <v-card outlined>
        <v-card-title>
            RegisterIssuedDocument
        </v-card-title>

        <v-card-text>
            <Number label="DocumentId" v-model="value.documentId" :editMode="editMode"/>
            <String label="SystemIntegration" v-model="value.systemIntegration" :editMode="editMode"/>
            <String label="DocumentClassification" v-model="value.documentClassification" :editMode="editMode"/>
            <String label="SecurityLevel" v-model="value.securityLevel" :editMode="editMode"/>
            <Number label="RetentionPeriod" v-model="value.retentionPeriod" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registerIssuedDocument"
            >
                RegisterIssuedDocument
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
        name: 'RegisterIssuedDocumentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.documentId = 0;
            this.value.systemIntegration = '';
            this.value.documentClassification = '';
            this.value.securityLevel = '';
            this.value.retentionPeriod = 0;
        },
        watch: {
        },
        methods: {
            registerIssuedDocument() {
                this.$emit('registerIssuedDocument', this.value);
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

