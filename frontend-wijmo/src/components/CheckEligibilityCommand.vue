<template>

    <v-card outlined>
        <v-card-title>
            CheckEligibility
        </v-card-title>

        <v-card-text>
            <String label="ApplicantId" v-model="value.applicantId" :editMode="editMode"/>
            <String label="ResidentRegistrationNumber" v-model="value.residentRegistrationNumber" :editMode="editMode"/>
            <String label="ForeignerRegistrationNumber" v-model="value.foreignerRegistrationNumber" :editMode="editMode"/>
            <String label="QualificationItems" v-model="value.qualificationItems" :editMode="editMode"/>
            <String label="ApiKey" v-model="value.apiKey" :editMode="editMode"/>
            <String label="AuthToken" v-model="value.authToken" :editMode="editMode"/>
            <String label="IpRestriction" v-model="value.ipRestriction" :editMode="editMode"/>
            <String label="DigitalSignature" v-model="value.digitalSignature" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="checkEligibility"
            >
                CheckEligibility
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CheckEligibilityCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.applicantId = '';
            this.value.residentRegistrationNumber = '';
            this.value.foreignerRegistrationNumber = '';
            this.value.qualificationItems = [];
            this.value.apiKey = '';
            this.value.authToken = '';
            this.value.ipRestriction = '';
            this.value.digitalSignature = '';
        },
        watch: {
        },
        methods: {
            checkEligibility() {
                this.$emit('checkEligibility', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

