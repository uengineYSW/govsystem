<template>
    <div style="max-height:80vh;">
        <div class="hierarchy">
            <div>민원 서비스 신청 및 서식 조회 &nbsp; ></div>
            <div>&nbsp; 민원 서비스 신청</div>
        </div>
        <div class="gs-bundle-of-buttons" style="max-height:10vh;">
            <v-btn @click="addNewRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-plus-circle-outline</v-icon>등록
            </v-btn>
            <v-btn  @click="editSelectedRow" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-pencil</v-icon>수정
            </v-btn>
            <v-btn @click="submitServiceApplicationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>민원 서비스 신청 제출
            </v-btn>
            <v-dialog v-model="submitServiceApplicationDialog" width="500">
                <SubmitServiceApplicationCommand
                    @closeDialog="submitServiceApplicationDialog = false"
                    @submitServiceApplication="submitServiceApplication"
                ></SubmitServiceApplicationCommand>
            </v-dialog>
            <v-btn @click="saveTemporaryServiceApplicationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                <v-icon small>mdi-minus-circle-outline</v-icon>민원 서비스 임시저장
            </v-btn>
            <v-dialog v-model="saveTemporaryServiceApplicationDialog" width="500">
                <SaveTemporaryServiceApplicationCommand
                    @closeDialog="saveTemporaryServiceApplicationDialog = false"
                    @saveTemporaryServiceApplication="saveTemporaryServiceApplication"
                ></SaveTemporaryServiceApplicationCommand>
            </v-dialog>
            <v-btn @click="deleteSelectedRows" class="contrast-primary-text" small color="primary" :disabled="!hasRole('')">
                <v-icon small>mdi-minus-circle-outline</v-icon>삭제
            </v-btn>
            <excel-export-button class="contrast-primary-text" :exportService="this.exportService" :getFlex="getFlex" />
        </div>
        <ServiceApplicationStatus @search="search"></ServiceApplicationStatus>
        <ServiceApplicationDraft @search="search"></ServiceApplicationDraft>
        <ServiceApplicationFormMapping @search="search"></ServiceApplicationFormMapping>


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
            <wj-flex-grid-filter :filterColumns="['RowHeader','user','serviceType','formData','attachment','progressStatus',]" />
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="user" header="사용자" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">   
                    <User v-model="cell.item.user" :editMode="editMode"></User>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="serviceType" header="ServiceType" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="formData" header="FormData" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="attachment" header="Attachment" width="2*" :isReadOnly="true" align="center" />
            <wj-flex-grid-column binding="progressStatus" header="ProgressStatus" width="2*" :isReadOnly="true" align="center" />
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
                            <div style="color:white; font-size:17px; font-weight:700;">민원 서비스 신청 등록</div>
                            <v-spacer></v-spacer>
                            <v-icon
                                color="white"
                                small
                                @click="closeDialog()"
                            >mdi-close</v-icon>
                        </v-toolbar>
                        <v-card-text>
                            <ServiceApplication :offline="offline"
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
    name: 'serviceApplicationGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'serviceApplications',
        submitServiceApplicationDialog: false,
        saveTemporaryServiceApplicationDialog: false,
    }),
    watch: {
    },
    methods:{
        submitServiceApplication(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','SubmitServiceApplication 성공적으로 처리되었습니다.')
                this.submitServiceApplicationDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
        saveTemporaryServiceApplication(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "", params)
                this.$EventBus.$emit('show-success','SaveTemporaryServiceApplication 성공적으로 처리되었습니다.')
                this.saveTemporaryServiceApplicationDialog = false
            }catch(e){
                this.$EventBus.$emit('show-error', e);
            }
            
        },
    }
}
</script>