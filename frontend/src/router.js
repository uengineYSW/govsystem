
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ServiceApplicationServiceApplicationManager from "./components/listers/ServiceApplicationServiceApplicationCards"
import ServiceApplicationServiceApplicationDetail from "./components/listers/ServiceApplicationServiceApplicationDetail"
import ServiceApplicationFormTemplateManager from "./components/listers/ServiceApplicationFormTemplateCards"
import ServiceApplicationFormTemplateDetail from "./components/listers/ServiceApplicationFormTemplateDetail"

import ServiceApplicationStatusView from "./components/ServiceApplicationStatusView"
import ServiceApplicationStatusViewDetail from "./components/ServiceApplicationStatusViewDetail"
import ServiceApplicationDraftView from "./components/ServiceApplicationDraftView"
import ServiceApplicationDraftViewDetail from "./components/ServiceApplicationDraftViewDetail"
import ServiceApplicationFormMappingView from "./components/ServiceApplicationFormMappingView"
import ServiceApplicationFormMappingViewDetail from "./components/ServiceApplicationFormMappingViewDetail"
import FormTemplatePreviewView from "./components/FormTemplatePreviewView"
import FormTemplatePreviewViewDetail from "./components/FormTemplatePreviewViewDetail"
import EligibilityVerificationEligibilityCheckManager from "./components/listers/EligibilityVerificationEligibilityCheckCards"
import EligibilityVerificationEligibilityCheckDetail from "./components/listers/EligibilityVerificationEligibilityCheckDetail"

import EligibilityInquiryHistoryView from "./components/EligibilityInquiryHistoryView"
import EligibilityInquiryHistoryViewDetail from "./components/EligibilityInquiryHistoryViewDetail"
import DataCollectionExternalDataManager from "./components/listers/DataCollectionExternalDataCards"
import DataCollectionExternalDataDetail from "./components/listers/DataCollectionExternalDataDetail"

import ExternalDataQueryHistoryView from "./components/ExternalDataQueryHistoryView"
import ExternalDataQueryHistoryViewDetail from "./components/ExternalDataQueryHistoryViewDetail"
import ApplicationDocumentApplicationDocumentManager from "./components/listers/ApplicationDocumentApplicationDocumentCards"
import ApplicationDocumentApplicationDocumentDetail from "./components/listers/ApplicationDocumentApplicationDocumentDetail"

import ApplicationDocumentDetailsView from "./components/ApplicationDocumentDetailsView"
import ApplicationDocumentDetailsViewDetail from "./components/ApplicationDocumentDetailsViewDetail"
import DocumentIssuanceIssuedDocumentManager from "./components/listers/DocumentIssuanceIssuedDocumentCards"
import DocumentIssuanceIssuedDocumentDetail from "./components/listers/DocumentIssuanceIssuedDocumentDetail"

import IssuedDocumentStatusView from "./components/IssuedDocumentStatusView"
import IssuedDocumentStatusViewDetail from "./components/IssuedDocumentStatusViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/serviceApplications/serviceApplications',
                name: 'ServiceApplicationServiceApplicationManager',
                component: ServiceApplicationServiceApplicationManager
            },
            {
                path: '/serviceApplications/serviceApplications/:id',
                name: 'ServiceApplicationServiceApplicationDetail',
                component: ServiceApplicationServiceApplicationDetail
            },
            {
                path: '/serviceApplications/formTemplates',
                name: 'ServiceApplicationFormTemplateManager',
                component: ServiceApplicationFormTemplateManager
            },
            {
                path: '/serviceApplications/formTemplates/:id',
                name: 'ServiceApplicationFormTemplateDetail',
                component: ServiceApplicationFormTemplateDetail
            },

            {
                path: '/serviceApplications/serviceApplicationStatuses',
                name: 'ServiceApplicationStatusView',
                component: ServiceApplicationStatusView
            },
            {
                path: '/serviceApplications/serviceApplicationStatuses/:id',
                name: 'ServiceApplicationStatusViewDetail',
                component: ServiceApplicationStatusViewDetail
            },
            {
                path: '/serviceApplications/serviceApplicationDrafts',
                name: 'ServiceApplicationDraftView',
                component: ServiceApplicationDraftView
            },
            {
                path: '/serviceApplications/serviceApplicationDrafts/:id',
                name: 'ServiceApplicationDraftViewDetail',
                component: ServiceApplicationDraftViewDetail
            },
            {
                path: '/serviceApplications/serviceApplicationFormMappings',
                name: 'ServiceApplicationFormMappingView',
                component: ServiceApplicationFormMappingView
            },
            {
                path: '/serviceApplications/serviceApplicationFormMappings/:id',
                name: 'ServiceApplicationFormMappingViewDetail',
                component: ServiceApplicationFormMappingViewDetail
            },
            {
                path: '/serviceApplications/formTemplatePreviews',
                name: 'FormTemplatePreviewView',
                component: FormTemplatePreviewView
            },
            {
                path: '/serviceApplications/formTemplatePreviews/:id',
                name: 'FormTemplatePreviewViewDetail',
                component: FormTemplatePreviewViewDetail
            },
            {
                path: '/eligibilityVerifications/eligibilityChecks',
                name: 'EligibilityVerificationEligibilityCheckManager',
                component: EligibilityVerificationEligibilityCheckManager
            },
            {
                path: '/eligibilityVerifications/eligibilityChecks/:id',
                name: 'EligibilityVerificationEligibilityCheckDetail',
                component: EligibilityVerificationEligibilityCheckDetail
            },

            {
                path: '/eligibilityVerifications/eligibilityInquiryHistories',
                name: 'EligibilityInquiryHistoryView',
                component: EligibilityInquiryHistoryView
            },
            {
                path: '/eligibilityVerifications/eligibilityInquiryHistories/:id',
                name: 'EligibilityInquiryHistoryViewDetail',
                component: EligibilityInquiryHistoryViewDetail
            },
            {
                path: '/dataCollections/externalData',
                name: 'DataCollectionExternalDataManager',
                component: DataCollectionExternalDataManager
            },
            {
                path: '/dataCollections/externalData/:id',
                name: 'DataCollectionExternalDataDetail',
                component: DataCollectionExternalDataDetail
            },

            {
                path: '/dataCollections/externalDataQueryHistories',
                name: 'ExternalDataQueryHistoryView',
                component: ExternalDataQueryHistoryView
            },
            {
                path: '/dataCollections/externalDataQueryHistories/:id',
                name: 'ExternalDataQueryHistoryViewDetail',
                component: ExternalDataQueryHistoryViewDetail
            },
            {
                path: '/applicationDocuments/applicationDocuments',
                name: 'ApplicationDocumentApplicationDocumentManager',
                component: ApplicationDocumentApplicationDocumentManager
            },
            {
                path: '/applicationDocuments/applicationDocuments/:id',
                name: 'ApplicationDocumentApplicationDocumentDetail',
                component: ApplicationDocumentApplicationDocumentDetail
            },

            {
                path: '/applicationDocuments/applicationDocumentDetails',
                name: 'ApplicationDocumentDetailsView',
                component: ApplicationDocumentDetailsView
            },
            {
                path: '/applicationDocuments/applicationDocumentDetails/:id',
                name: 'ApplicationDocumentDetailsViewDetail',
                component: ApplicationDocumentDetailsViewDetail
            },
            {
                path: '/documentIssuances/issuedDocuments',
                name: 'DocumentIssuanceIssuedDocumentManager',
                component: DocumentIssuanceIssuedDocumentManager
            },
            {
                path: '/documentIssuances/issuedDocuments/:id',
                name: 'DocumentIssuanceIssuedDocumentDetail',
                component: DocumentIssuanceIssuedDocumentDetail
            },

            {
                path: '/documentIssuances/issuedDocumentStatuses',
                name: 'IssuedDocumentStatusView',
                component: IssuedDocumentStatusView
            },
            {
                path: '/documentIssuances/issuedDocumentStatuses/:id',
                name: 'IssuedDocumentStatusViewDetail',
                component: IssuedDocumentStatusViewDetail
            },


    ]
})
