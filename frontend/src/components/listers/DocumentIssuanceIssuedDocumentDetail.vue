<template>
    <v-card outlined>
        <v-card-title>
            IssuedDocument # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DocumentId" v-model="item.documentId" :editMode="editMode" @change="change" />
            </div>
            <EdmsIntegrationInfo offline label="EdmsIntegrationInfo" v-model="item.edmsIntegrationInfo" :editMode="false" :key="false" @change="change" />
            <PdfProcessingInfo offline label="PdfProcessingInfo" v-model="item.pdfProcessingInfo" :editMode="false" :key="false" @change="change" />
            <EDMSStatus offline label="EdmsStatus" v-model="item.edmsStatus" :editMode="false" :key="false" @change="change" />
            <PDFDocumentStatus offline label="PdfStatus" v-model="item.pdfStatus" :editMode="false" :key="false" @change="change" />
            <EligibilityCheckId offline label="EligibilityCheckId" v-model="item.eligibilityCheckId" :editMode="false" :key="false" @change="change" />
            <ExternalDataId offline label="ExternalDataId" v-model="item.externalDataId" :editMode="false" :key="false" @change="change" />
            <ApplicationDocumentId offline label="ApplicationDocumentId" v-model="item.applicationDocumentId" :editMode="false" :key="false" @change="change" />
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
        name: 'DocumentIssuanceIssuedDocumentDetail',
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
            var temp = await axios.get(axios.fixUrl('/issuedDocuments/' + params.id))
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
