<template>
    <v-card outlined style="border-radius: 0; margin-top:-10px; padding-bottom:10px;">
        <v-card-title>
            서식 미리보기
        </v-card-title>
    
        <v-card-text style="margin-top:-30px;">
            <v-row no-gutters style="margin: 15px 0px -30px -15px;">
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="FormType" v-model="value.parameters.formType" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="TemplateId" v-model="value.parameters.templateId" :editMode="editMode"/>
                </v-col>
                <v-col>
                    <v-btn class="gs-query-search-btn contrast-primary-text"
                        @click="search"
                        small
                        color="primary"
                    >
                        <v-icon small>mdi-magnify</v-icon>검색
                    </v-btn>
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'FormTemplatePreview',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'formTemplates/search/findByFormTemplatePreview',
                parameters: {}
            },
        }),
        created() {
        },
        watch: {
        },
        methods: {
            search() {
                let search = null;
                search = this.value;
                this.$emit('search', search);
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
<style>
.attributes-list{
    margin-left: 15px;
}
</style>

