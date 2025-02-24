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
            <wj-flex-grid-column binding="systemIntegration" header="SystemIntegration" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="documentClassification" header="DocumentClassification" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="securityLevel" header="SecurityLevel" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="retentionPeriod" header="RetentionPeriod" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
                    <Number v-model="cell.item.retentionPeriod" :editMode="editMode"/>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
        </wj-flex-grid>
    </div>
</template>

<script>
import BaseDetailGrid from '../base-ui/BaseDetailGrid';

export default {
    name: 'EdmsIntegrationInfoDetailGrid',
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

