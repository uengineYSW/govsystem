<template>

    <v-card outlined>
        <v-card-title>
            ApplicationFormData
        </v-card-title>

        <v-card-text>
            <String label="TemplateCode" v-model="value.templateCode" :editMode="editMode"/>
            <String label="SignaturePosition" v-model="value.signaturePosition" :editMode="editMode"/>
            <String label="Attachments" v-model="value.attachments" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'ApplicationFormData',
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
                    'templateCode': '',
                    'signaturePosition': '',
                    'attachments': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('templateCode' in this.value)) {
                    this.value.templateCode = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('signaturePosition' in this.value)) {
                    this.value.signaturePosition = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('attachments' in this.value)) {
                    this.value.attachments = '';
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

