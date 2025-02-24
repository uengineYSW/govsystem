<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>신청서 작성 &nbsp; ></div>
            <div>&nbsp; 신청서 작성</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="submitApplicationDocumentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>신청서 제출
            </v-btn>
            <v-dialog v-model="submitApplicationDocumentDialog" width="500">
                <SubmitApplicationDocumentCommand
                    @closeDialog="submitApplicationDocumentDialog = false"
                    @submitApplicationDocument="submitApplicationDocument"
                ></SubmitApplicationDocumentCommand>
            </v-dialog>
            <v-btn @click="saveDraftApplicationDocumentDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>신청서 임시저장
            </v-btn>
            <v-dialog v-model="saveDraftApplicationDocumentDialog" width="500">
                <SaveDraftApplicationDocumentCommand
                    @closeDialog="saveDraftApplicationDocumentDialog = false"
                    @saveDraftApplicationDocument="saveDraftApplicationDocument"
                ></SaveDraftApplicationDocumentCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <ApplicationDocumentDetails @search="search"></ApplicationDocumentDetails>


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
            <wj-flex-grid-filter :filterColumns="['RowHeader','applicationFormData','electronicSignatureData','draftHistoryRecord','securityRating','serviceApplicationId','formTemplateId',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="applicationFormData" header="신청서 데이터" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ApplicationFormData v-model="cell.item.applicationFormData" :editMode="editMode"></ApplicationFormData>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="electronicSignatureData" header="ElectronicSignatureData" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="draftHistoryRecord" header="작성 이력 기록" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <DraftHistoryRecord v-model="cell.item.draftHistoryRecord" :editMode="editMode"></DraftHistoryRecord>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="securityRating" header="SecurityRating" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="serviceApplicationId" header="serviceApplicationId" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ServiceApplicationId v-model="cell.item.serviceApplicationId" :editMode="editMode"></ServiceApplicationId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="formTemplateId" header="formTemplateId" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <FormTemplateId v-model="cell.item.formTemplateId" :editMode="editMode"></FormTemplateId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="serviceApplicationId" header="민원 서비스 신청" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ServiceApplicationId v-model="cell.item.serviceApplicationId" :editMode="editMode"></ServiceApplicationId>
                    {{ cell.item.serviceApplicationId }}
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="formTemplateId" header="서식 조회" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <FormTemplateId v-model="cell.item.formTemplateId" :editMode="editMode"></FormTemplateId>
                    {{ cell.item.formTemplateId }}
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
                            <div style="color:white; font-size:17px; font-weight:700;">신청서 작성 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <ApplicationDocument :offline="offline"
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
    name: 'applicationDocumentGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'applicationDocuments',
        submitApplicationDocumentDialog: false,
        saveDraftApplicationDocumentDialog: false,
    }),
    watch: {
    },
    methods:{
        submitApplicationDocument(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','SubmitApplicationDocument 성공적으로 처리되었습니다.')
                this.submitApplicationDocumentDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
        saveDraftApplicationDocument(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','SaveDraftApplicationDocument 성공적으로 처리되었습니다.')
                this.saveDraftApplicationDocumentDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
    }
}
</script>