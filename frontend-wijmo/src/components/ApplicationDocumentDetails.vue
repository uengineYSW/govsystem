<template>
    <v-card outlined style="border-radius: 0; margin-top:-10px; padding-bottom:10px;">
        <v-card-title>
            신청서 상세 정보
        </v-card-title>
    
        <v-card-text style="margin-top:-30px;">
            <v-row no-gutters style="margin: 15px 0px -30px -15px;">
                <v-col style="max-width:140px;">
                    <Number class="attributes-list" label="DocumentId" v-model="value.parameters.documentId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <ApplicationFormData offline label="ApplicationFormData" v-model="value.parameters.applicationFormData" :editMode="editMode" @change="change"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="ElectronicSignatureData" v-model="value.parameters.electronicSignatureData" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <DraftHistoryRecord offline label="DraftHistoryRecord" v-model="value.parameters.draftHistoryRecord" :editMode="editMode" @change="change"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <SecurityRating offline label="SecurityRating" v-model="value.parameters.securityRating" :editMode="editMode" @change="change"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <ServiceApplicationId offline label="ServiceApplicationId" v-model="value.parameters.serviceApplicationId" :editMode="editMode" @change="change"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <FormTemplateId offline label="FormTemplateId" v-model="value.parameters.formTemplateId" :editMode="editMode" @change="change"/>
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
        name: 'ApplicationDocumentDetails',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'applicationDocuments/search/findByApplicationDocumentDetails',
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

