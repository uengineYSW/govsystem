<template>
    <div>
        <div class="label-title">{{label}}</div>
        <v-btn v-if="editMode" @click="append()">추가</v-btn>
        <v-btn v-if="editMode" @click="deleteDetailRow()">삭제</v-btn>
        <wj-flex-grid
            ref="flexGridDetails"
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
            :initialized="flexDetailsInitialized"
            style="margin-top:10px; max-height:65vh;"
        >
            <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">{{cell.row.index + 1}}</wj-flex-grid-cell-template>
            <wj-flex-grid-column binding="inquiryId" header="InquiryId" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="applicantId" header="ApplicantId" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="residentRegistrationNumber" header="ResidentRegistrationNumber" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="foreignerRegistrationNumber" header="ForeignerRegistrationNumber" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="rejectionReason" header="RejectionReason" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="inquiryTime" header="InquiryTime" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
                    <Date v-model="cell.item.inquiryTime" :editMode="editMode"/>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="qualificationStatus.name" header="자격 상태" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
                    <QualificationStatus v-model="cell.item.qualificationStatus" :editMode="editMode"></QualificationStatus>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
        </wj-flex-grid>
    </div>
</template>

<script>
import BaseDetailGrid from '../base-ui/BaseDetailGrid';

export default {
    name: 'InquiryHistoryItemDetailGrid',
    mixins: [BaseDetailGrid],
    components: {
    },
    props: {
        label: String,
    },
    methods: {
    }
}
</script>

