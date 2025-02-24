<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>발급문서 처리 및 EDMS 연계 &nbsp; ></div>
            <div>&nbsp; 발급문서 처리</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="registerIssuedDocumentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-minus-circle-outline</v-icon>EDMS 문서 등록
            </v-btn>
            <v-dialog v-model="registerIssuedDocumentDialog" width="500">
                <RegisterIssuedDocumentCommand
                    @closeDialog="registerIssuedDocumentDialog = false"
                    @registerIssuedDocument="registerIssuedDocument"
                ></RegisterIssuedDocumentCommand>
            </v-dialog>
            <v-btn @click="processIssuedDocumentPdfDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                <v-icon small>mdi-minus-circle-outline</v-icon>PDF 문서 처리
            </v-btn>
            <v-dialog v-model="processIssuedDocumentPdfDialog" width="500">
                <ProcessIssuedDocumentPdfCommand
                    @closeDialog="processIssuedDocumentPdfDialog = false"
                    @processIssuedDocumentPdf="processIssuedDocumentPdf"
                ></ProcessIssuedDocumentPdfCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <IssuedDocumentStatus @search="search"></IssuedDocumentStatus>


        <!-- the grid -->
        <wj-flex-grid
            ref="flexGrid"
            :key="value.length"
            :autoGenerateColumns="false"
            :allowAddNew="false"
            :allowDelete="true"
            :allowPinning="'SingleColumn'"
            :newRowAtTop="false"
            :showMarquee="true"
            :selectionMode="'MultiRange'"
            :validateEdits="false"
            :itemsSource="value"
            :initialized="flexInitialized"
            :selectionChanged="onSelectionChanged"
            style="margin-top:10px; max-height:65vh;"
            class="wj-felx-grid"
        >
            <wj-flex-grid-filter :filterColumns="['RowHeader','edmsIntegrationInfo','pdfProcessingInfo','edmsStatus','pdfStatus','eligibilityCheckId','externalDataId','applicationDocumentId',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="edmsIntegrationInfo" header="EDMS 연계 정보" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <EdmsIntegrationInfo v-model="cell.item.edmsIntegrationInfo" :editMode="editMode"></EdmsIntegrationInfo>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="pdfProcessingInfo" header="PDF 처리 정보" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <PdfProcessingInfo v-model="cell.item.pdfProcessingInfo" :editMode="editMode"></PdfProcessingInfo>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="edmsStatus" header="EdmsStatus" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="pdfStatus" header="PdfStatus" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="eligibilityCheckId" header="eligibilityCheckId" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <EligibilityCheckId v-model="cell.item.eligibilityCheckId" :editMode="editMode"></EligibilityCheckId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="externalDataId" header="externalDataId" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ExternalDataId v-model="cell.item.externalDataId" :editMode="editMode"></ExternalDataId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="applicationDocumentId" header="applicationDocumentId" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ApplicationDocumentId v-model="cell.item.applicationDocumentId" :editMode="editMode"></ApplicationDocumentId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="eligibilityCheckId" header="자격 조회" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <EligibilityCheckId v-model="cell.item.eligibilityCheckId" :editMode="editMode"></EligibilityCheckId>
                    {{ cell.item.eligibilityCheckId }}
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="externalDataId" header="추가 데이터 조회" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ExternalDataId v-model="cell.item.externalDataId" :editMode="editMode"></ExternalDataId>
                    {{ cell.item.externalDataId }}
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="applicationDocumentId" header="신청서 작성" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ApplicationDocumentId v-model="cell.item.applicationDocumentId" :editMode="editMode"></ApplicationDocumentId>
                    {{ cell.item.applicationDocumentId }}
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
        </wj-flex-grid>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <template>
                    <v-card>
                        <v-toolbar
                            color="primary"
                            class="elevation-0"
                            height="50px"
                        >
                            <div style="color:white; font-size:17px; font-weight:700;">발급문서 처리 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <IssuedDocument :offline="offline"
                                :isNew="!itemToEdit"
                                :editMode="true"
                                v-model="newValue"
                                @add="append"
                                @edit="edit"
                            />
                        </v-card-text>
                    </v-card>
                </template>
            </v-dialog>
        </v-col>
        <v-col style="margin-bottom:40px;">
            <div class="text-center">
                <v-dialog
                    width="332.5"
                    fullscreen
                    hide-overlay
                    transition="dialog-bottom-transition"
                >
                    <v-btn
                        style="position:absolute; top:2%; right:2%"
                        @click="closeDialog()"
                        depressed
                        icon 
                        absolute
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </v-dialog>
            </div>
        </v-col>
    </div>
</template>

<script>
import BaseGrid from '../base-ui/BaseGrid'

export default {
    name: 'issuedDocumentGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'issuedDocuments',
        registerIssuedDocumentDialog: false,
        processIssuedDocumentPdfDialog: false,
    }),
    watch: {
    },
    methods:{
        registerIssuedDocument(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','RegisterIssuedDocument 성공적으로 처리되었습니다.')
                this.registerIssuedDocumentDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
        processIssuedDocumentPdf(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','ProcessIssuedDocumentPDF 성공적으로 처리되었습니다.')
                this.processIssuedDocumentPdfDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
    }
}
</script>