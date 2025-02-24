<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>자격 조회 &nbsp; ></div>
            <div>&nbsp; 자격 조회</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="checkEligibilityDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>자격 조회 실행
            </v-btn>
            <v-dialog v-model="checkEligibilityDialog" width="500">
                <CheckEligibilityCommand
                    @closeDialog="checkEligibilityDialog = false"
                    @checkEligibility="checkEligibility"
                ></CheckEligibilityCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <EligibilityInquiryHistory @search="search"></EligibilityInquiryHistory>


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
            <wj-flex-grid-filter :filterColumns="['RowHeader','qualificationStatus','inquiryHistory','serviceApplicationId',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="qualificationStatus" header="QualificationStatus" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="inquiryHistory" header="자격 조회 이력 항목" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <InquiryHistoryItem v-model="cell.item.inquiryHistory" :editMode="editMode"></InquiryHistoryItem>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="serviceApplicationId" header="serviceApplicationId" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ServiceApplicationId v-model="cell.item.serviceApplicationId" :editMode="editMode"></ServiceApplicationId>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="serviceApplicationId" header="민원 서비스 신청" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <ServiceApplicationId v-model="cell.item.serviceApplicationId" :editMode="editMode"></ServiceApplicationId>
                    {{ cell.item.serviceApplicationId }}
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
                            <div style="color:white; font-size:17px; font-weight:700;">자격 조회 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <EligibilityCheck :offline="offline"
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
    name: 'eligibilityCheckGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'eligibilityChecks',
        checkEligibilityDialog: false,
    }),
    watch: {
    },
    methods:{
        checkEligibility(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','CheckEligibility 성공적으로 처리되었습니다.')
                this.checkEligibilityDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
    }
}
</script>