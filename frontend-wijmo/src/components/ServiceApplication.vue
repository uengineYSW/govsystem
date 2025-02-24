<template>
    <div>
        <String label="ApplicationId" v-model="value.applicationId" :editMode="editMode"/>
        <String label="ServiceType" v-model="value.serviceType" :editMode="editMode"/>
        <String label="FormData" v-model="value.formData" :editMode="editMode"/>
        <String label="Attachment" v-model="value.attachment" :editMode="editMode"/>
        <User offline label="사용자" v-model="value.user" :editMode="editMode" @change="change"/>
        <ProgressStatus offline label="ProgressStatus" v-model="value.progressStatus" :editMode="editMode" @change="change"/>

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
    name: 'ServiceApplication',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "serviceApplications"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

