<template>
    <v-card outlined>
        <v-card-title>
            SaveTemporaryServiceApplication
        </v-card-title>

        <v-card-text>
            <User offline label="User" v-model="value.user" :editMode="editMode" @change="change"/>
            <String label="ServiceType" v-model="value.serviceType" :editMode="editMode"/>
            <String label="FormData" v-model="value.formData" :editMode="editMode"/>
            <String label="Attachment" v-model="value.attachment" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="saveTemporaryServiceApplication"
            >
                SaveTemporaryServiceApplication
            </v-btn>
            
            <v-btn
                    color="primary"
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
        name: 'SaveTemporaryServiceApplicationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.user = {};
            this.value.serviceType = '';
            this.value.formData = '';
            this.value.attachment = '';
        },
        watch: {
        },
        methods: {
            saveTemporaryServiceApplication() {
                this.$emit('saveTemporaryServiceApplication', this.value);
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

