<template>
    <v-card outlined style="border-radius: 0; margin-top:-10px; padding-bottom:10px;">
        <v-card-title>
            민원 신청 임시저장 조회
        </v-card-title>
    
        <v-card-text style="margin-top:-30px;">
            <v-row no-gutters style="margin: 15px 0px -30px -15px;">
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="UserId" v-model="value.parameters.userId" :editMode="editMode"/>
                </v-col>
                <v-col>
                    <v-btn class="gs-query-search-btn contrast-primary-text"
                        @click="search"
                        small
                        color="primary"
                    >
                        <v-icon small>mdi-magnify</v-icon>검색
                    </v-btn>
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'ServiceApplicationDraft',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'serviceApplications/search/findByServiceApplicationDraft',
                parameters: {}
            },
        }),
        created() {
        },
        watch: {
        },
        methods: {
            search() {
                let search = null;
                search = this.value;
                this.$emit('search', search);
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
<style>
.attributes-list{
    margin-left: 15px;
}
</style>

