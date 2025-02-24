<template>
    <div>
        <Number label="DocumentId" v-model="value.documentId" :editMode="editMode"/>
        <String label="ElectronicSignatureData" v-model="value.electronicSignatureData" :editMode="editMode"/>
        <ApplicationFormData offline label="신청서 데이터" v-model="value.applicationFormData" :editMode="editMode" @change="change"/>
        <DraftHistoryRecord offline label="작성 이력 기록" v-model="value.draftHistoryRecord" :editMode="editMode" @change="change"/>
        <ServiceApplicationId offline label="serviceApplicationId" v-model="value.serviceApplicationId" :editMode="editMode" @change="change"/>
        <FormTemplateId offline label="formTemplateId" v-model="value.formTemplateId" :editMode="editMode" @change="change"/>

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
    name: 'ApplicationDocument',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "applicationDocuments"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

