<template>

    <v-card outlined>
        <v-card-title>
            EdmsIntegrationInfo
        </v-card-title>

        <v-card-text>
            <String label="SystemIntegration" v-model="value.systemIntegration" :editMode="editMode"/>
            <String label="DocumentClassification" v-model="value.documentClassification" :editMode="editMode"/>
            <String label="SecurityLevel" v-model="value.securityLevel" :editMode="editMode"/>
            <Number label="RetentionPeriod" v-model="value.retentionPeriod" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'EdmsIntegrationInfo',
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
                    'systemIntegration': '',
                    'documentClassification': '',
                    'securityLevel': '',
                    'retentionPeriod': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('systemIntegration' in this.value)) {
                    this.value.systemIntegration = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('documentClassification' in this.value)) {
                    this.value.documentClassification = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('securityLevel' in this.value)) {
                    this.value.securityLevel = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('retentionPeriod' in this.value)) {
                    this.value.retentionPeriod = 0;
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

