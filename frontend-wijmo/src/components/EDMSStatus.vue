<template>
    <div style="margin: -10px -15px 0 -15px;">
        <v-card-text>
            <div class="label-title"></div>
            <div v-if="editMode">
                <v-select
                    v-model="newValue"
                    :label="label"
                    :items="selections"
                    solo
                ></v-select>
            </div>
            <div v-else>
                EDMSStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue';

export default {
    name: 'EDMSStatus',
    mixins:[BaseEntity],
    components:{},
    props: {
        label: String
    },
    data: () => ({
        selections : ["REGISTERED","IN_PROGRESS","COMPLETED","FAILED"],
        newValue: '',
    }),
    async created() {
        if(!this.value) {
            this.newValue = this.EDMSStatusList[0];
        } else {
            this.newValue = this.value;
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
    }
}
</script>

