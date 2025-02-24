<template>

    <div>
        <div class="detail-title">
        PdfProcessingInfo
        </div>
        <v-col>
            <String label="Template" v-model="value.template" :editMode="editMode"/>
            <String label="Font" v-model="value.font" :editMode="editMode"/>
            <Number label="Margin" v-model="value.margin" :editMode="editMode"/>
            <String label="Resolution" v-model="value.resolution" :editMode="editMode"/>
            <String label="EncryptionLevel" v-model="value.encryptionLevel" :editMode="editMode"/>
            <Boolean label="OutputControl" v-model="value.outputControl" :editMode="editMode"/>
            <String label="WatermarkPosition" v-model="value.watermarkPosition" :editMode="editMode"/>
            <String label="SecurityLevel" v-model="value.securityLevel" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'PdfProcessingInfo',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'PDFProcessingInfos',
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
        if (this.value && this.value.eligibilityCheckIdcollectionIddocumentId !== undefined) {
            this.value = await this.repository.findById(this.value.eligibilityCheckIdcollectionIddocumentId)
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

