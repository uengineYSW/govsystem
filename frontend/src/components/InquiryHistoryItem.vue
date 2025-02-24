<template>

    <v-card outlined>
        <v-card-title>
            InquiryHistoryItem
        </v-card-title>

        <v-card-text>
            <String label="InquiryId" v-model="value.inquiryId" :editMode="editMode"/>
            <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode"/>
            <String label="ResidentRegistrationNumber" v-model="value.residentRegistrationNumber" :editMode="editMode"/>
            <String label="ForeignerRegistrationNumber" v-model="value.foreignerRegistrationNumber" :editMode="editMode"/>
            <String label="RejectionReason" v-model="value.rejectionReason" :editMode="editMode"/>
            <Date label="InquiryTime" v-model="value.inquiryTime" :editMode="editMode"/>
            <QualificationStatus offline label="QualificationStatus" v-model="value.qualificationStatus" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'InquiryHistoryItem',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'inquiryId': '',
                    'applicantId': '',
                    'residentRegistrationNumber': '',
                    'foreignerRegistrationNumber': '',
                    'rejectionReason': '',
                    'inquiryTime': '',
                    'qualificationStatus': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('inquiryId' in this.value)) {
                    this.value.inquiryId = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('applicantId' in this.value)) {
                    this.value.applicantId = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('residentRegistrationNumber' in this.value)) {
                    this.value.residentRegistrationNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('foreignerRegistrationNumber' in this.value)) {
                    this.value.foreignerRegistrationNumber = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('rejectionReason' in this.value)) {
                    this.value.rejectionReason = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('inquiryTime' in this.value)) {
                    this.value.inquiryTime = '2025-02-24';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

