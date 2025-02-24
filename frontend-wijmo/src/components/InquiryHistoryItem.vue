<template>

    <div>
        <div class="detail-title">
        InquiryHistoryItem
        </div>
        <v-col>
            <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode"/>
            <String label="ResidentRegistrationNumber" v-model="value.residentRegistrationNumber" :editMode="editMode"/>
            <String label="ForeignerRegistrationNumber" v-model="value.foreignerRegistrationNumber" :editMode="editMode"/>
            <String label="RejectionReason" v-model="value.rejectionReason" :editMode="editMode"/>
            <Date label="InquiryTime" v-model="value.inquiryTime" :editMode="editMode"/>
            <QualificationStatus offline label="자격 상태" v-model="value.qualificationStatus" :editMode="editMode" @change="change"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'InquiryHistoryItem',
    mixins:[BaseEntity],
    components:{
    },
    data: () => ({
        path: 'InquiryHistoryItems',
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
        if (this.value && this.value.applicationId !== undefined) {
            this.value = await this.repository.findById(this.value.applicationId)
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

