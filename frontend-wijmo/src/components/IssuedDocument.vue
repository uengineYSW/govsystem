<template>
    <div>
        <Number label="DocumentId" v-model="value.documentId" :editMode="editMode"/>
        <EdmsIntegrationInfo offline label="EDMS 연계 정보" v-model="value.edmsIntegrationInfo" :editMode="editMode" @change="change"/>
        <PdfProcessingInfo offline label="PDF 처리 정보" v-model="value.pdfProcessingInfo" :editMode="editMode" @change="change"/>
        <EDMSStatus offline label="EdmsStatus" v-model="value.edmsStatus" :editMode="editMode" @change="change"/>
        <PDFDocumentStatus offline label="PdfStatus" v-model="value.pdfStatus" :editMode="editMode" @change="change"/>
        <EligibilityCheckId offline label="eligibilityCheckId" v-model="value.eligibilityCheckId" :editMode="editMode" @change="change"/>
        <ExternalDataId offline label="externalDataId" v-model="value.externalDataId" :editMode="editMode" @change="change"/>
        <ApplicationDocumentId offline label="applicationDocumentId" v-model="value.applicationDocumentId" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'IssuedDocument',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "issuedDocuments"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

