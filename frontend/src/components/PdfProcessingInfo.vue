<template>

    <v-card outlined>
        <v-card-title>
            PdfProcessingInfo
        </v-card-title>

        <v-card-text>
            <String label="Template" v-model="value.template" :editMode="editMode"/>
            <String label="Font" v-model="value.font" :editMode="editMode"/>
            <Number label="Margin" v-model="value.margin" :editMode="editMode"/>
            <String label="Resolution" v-model="value.resolution" :editMode="editMode"/>
            <String label="EncryptionLevel" v-model="value.encryptionLevel" :editMode="editMode"/>
            <Boolean label="OutputControl" v-model="value.outputControl" :editMode="editMode"/>
            <String label="WatermarkPosition" v-model="value.watermarkPosition" :editMode="editMode"/>
            <String label="SecurityLevel" v-model="value.securityLevel" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'PdfProcessingInfo',
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
                    'template': '',
                    'font': '',
                    'margin': '',
                    'resolution': '',
                    'encryptionLevel': '',
                    'outputControl': '',
                    'watermarkPosition': '',
                    'securityLevel': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('template' in this.value)) {
                    this.value.template = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('font' in this.value)) {
                    this.value.font = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('margin' in this.value)) {
                    this.value.margin = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('resolution' in this.value)) {
                    this.value.resolution = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('encryptionLevel' in this.value)) {
                    this.value.encryptionLevel = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('outputControl' in this.value)) {
                    this.value.outputControl = false;
                }
            }
            if(typeof this.value === 'object') {
                if(!('watermarkPosition' in this.value)) {
                    this.value.watermarkPosition = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('securityLevel' in this.value)) {
                    this.value.securityLevel = '';
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

