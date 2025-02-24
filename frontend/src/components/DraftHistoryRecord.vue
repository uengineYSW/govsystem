<template>

    <v-card outlined>
        <v-card-title>
            DraftHistoryRecord
        </v-card-title>

        <v-card-text>
            <Date label="DraftTime" v-model="value.draftTime" :editMode="editMode"/>
            <String label="EditedBy" v-model="value.editedBy" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'DraftHistoryRecord',
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
                    'draftTime': '',
                    'editedBy': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('draftTime' in this.value)) {
                    this.value.draftTime = '2025-02-24';
                }
            }
            if(typeof this.value === 'object') {
                if(!('editedBy' in this.value)) {
                    this.value.editedBy = '';
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

