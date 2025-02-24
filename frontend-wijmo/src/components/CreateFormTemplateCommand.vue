<template>

    <v-card outlined>
        <v-card-title>
            CreateFormTemplate
        </v-card-title>

        <v-card-text>
            <String label="FormType" v-model="value.formType" :editMode="editMode"/>
            <String label="Version" v-model="value.version" :editMode="editMode"/>
            <String label="MappingRule" v-model="value.mappingRule" :editMode="editMode"/>
            <String label="PreviewContent" v-model="value.previewContent" :editMode="editMode"/>
            <String label="AlternativeTemplate" v-model="value.alternativeTemplate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createFormTemplate"
            >
                CreateFormTemplate
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
        name: 'CreateFormTemplateCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.formType = '';
            this.value.version = '';
            this.value.mappingRule = '';
            this.value.previewContent = '';
            this.value.alternativeTemplate = '';
        },
        watch: {
        },
        methods: {
            createFormTemplate() {
                this.$emit('createFormTemplate', this.value);
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

