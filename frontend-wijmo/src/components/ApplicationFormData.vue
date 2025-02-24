<template>

    <div>
        <div class="detail-title">
        ApplicationFormData
        </div>
        <v-col>
            <String label="TemplateCode" v-model="value.templateCode" :editMode="editMode"/>
            <String label="SignaturePosition" v-model="value.signaturePosition" :editMode="editMode"/>
            <String label="Attachments" v-model="value.attachments" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'ApplicationFormData',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'ApplicationFormDatas',
    }),
    props: {
    },
    
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    computed:{
        nameField(){
            var name = '';
            if(Object.keys(this.value).length < 3){
                name = "id"
            }else{
                const excludedKeys = ['_links','index'];
                const filteredKeys = Object.keys(this.value).filter(key => {
                    const valueType = typeof this.value[key];
                    return !excludedKeys.includes(key) && key !== 'id' && valueType !== 'object' && valueType !== 'number';
                });
                if(filteredKeys == []){
                    name = "id"
                }else{
                    name = filteredKeys[1]; 
                }
            }
            return name
        }
    },
    async created(){
        if (this.value && this.value.applicationIdtemplateId !== undefined) {
            this.value = await this.repository.findById(this.value.applicationIdtemplateId)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

