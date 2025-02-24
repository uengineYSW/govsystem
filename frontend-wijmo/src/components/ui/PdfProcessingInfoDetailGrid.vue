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
            <wj-flex-grid-column binding="template" header="Template" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="font" header="Font" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="margin" header="Margin" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
                    <Number v-model="cell.item.margin" :editMode="editMode"/>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="resolution" header="Resolution" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="encryptionLevel" header="EncryptionLevel" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="outputControl" header="OutputControl" width="2*" :isReadOnly="true" align="center">
                <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
                    <Boolean v-model="cell.item.outputControl" :editMode="editMode"/>
                </wj-flex-grid-cell-template>
            </wj-flex-grid-column>
            <wj-flex-grid-column binding="watermarkPosition" header="WatermarkPosition" width="2*" :isReadOnly="!editMode" align="center"/>
            <wj-flex-grid-column binding="securityLevel" header="SecurityLevel" width="2*" :isReadOnly="!editMode" align="center"/>
        </wj-flex-grid>
    </div>
</template>

<script>
import BaseDetailGrid from '../base-ui/BaseDetailGrid';

export default {
    name: 'PdfProcessingInfoDetailGrid',
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

