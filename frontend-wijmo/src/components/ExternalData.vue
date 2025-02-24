<template>
    <div>
        <String label="CollectionId" v-model="value.collectionId" :editMode="editMode"/>
        <String label="SystemName" v-model="value.systemName" :editMode="editMode"/>
        <String label="QueryItems" v-model="value.queryItems" :editMode="editMode"/>
        <String label="QueryPeriod" v-model="value.queryPeriod" :editMode="editMode"/>
        <Number label="Priority" v-model="value.priority" :editMode="editMode"/>
        <String label="DataProcessingRules" v-model="value.dataProcessingRules" :editMode="editMode"/>
        <DataVerificationStatus offline label="VerificationStatus" v-model="value.verificationStatus" :editMode="editMode" @change="change"/>
        <QueryHistoryItem offline label="조회 이력 항목" v-model="value.queryHistory" :editMode="editMode" @change="change"/>

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
    name: 'ExternalData',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "externalData"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

