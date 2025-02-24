<template>
    <v-card outlined>
        <v-card-title>
            ExternalData # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CollectionId" v-model="item.collectionId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="SystemName" v-model="item.systemName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="QueryItems" v-model="item.queryItems" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="QueryPeriod" v-model="item.queryPeriod" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Priority" v-model="item.priority" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DataProcessingRules" v-model="item.dataProcessingRules" :editMode="editMode" @change="change" />
            </div>
            <DataVerificationStatus offline label="VerificationStatus" v-model="item.verificationStatus" :editMode="false" :key="false" @change="change" />
            <QueryHistoryItem offline label="QueryHistory" v-model="item.queryHistory" :editMode="false" :key="false" @change="change" />
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'DataCollectionExternalDataDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/externalData/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
