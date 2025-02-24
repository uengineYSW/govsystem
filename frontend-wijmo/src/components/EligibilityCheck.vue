<template>
    <div>
        <String label="EligibilityCheckId" v-model="value.eligibilityCheckId" :editMode="editMode"/>
        <QualificationStatus offline label="QualificationStatus" v-model="value.qualificationStatus" :editMode="editMode" @change="change"/>
        <InquiryHistoryItem offline label="자격 조회 이력 항목" v-model="value.inquiryHistory" :editMode="editMode" @change="change"/>
        <ServiceApplicationId offline label="serviceApplicationId" v-model="value.serviceApplicationId" :editMode="editMode" @change="change"/>

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
    name: 'EligibilityCheck',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "eligibilityChecks"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

