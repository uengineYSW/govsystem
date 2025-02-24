<template>
    <div>
        <String label="TemplateId" v-model="value.templateId" :editMode="editMode"/>
        <String label="FormType" v-model="value.formType" :editMode="editMode"/>
        <String label="Version" v-model="value.version" :editMode="editMode"/>
        <String label="MappingRule" v-model="value.mappingRule" :editMode="editMode"/>
        <String label="PreviewContent" v-model="value.previewContent" :editMode="editMode"/>
        <String label="AlternativeTemplate" v-model="value.alternativeTemplate" :editMode="editMode"/>

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
    name: 'FormTemplate',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "formTemplates"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

