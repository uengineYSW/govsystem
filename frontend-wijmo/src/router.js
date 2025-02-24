
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ServiceApplicationManager from "./components/ui/ServiceApplicationGrid"
import FormTemplateManager from "./components/ui/FormTemplateGrid"

import EligibilityCheckManager from "./components/ui/EligibilityCheckGrid"

import ExternalDataManager from "./components/ui/ExternalDataGrid"

import ApplicationDocumentManager from "./components/ui/ApplicationDocumentGrid"

import IssuedDocumentManager from "./components/ui/IssuedDocumentGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/serviceApplications',
                name: 'ServiceApplicationManager',
                component: ServiceApplicationManager
            },
            {
                path: '/formTemplates',
                name: 'FormTemplateManager',
                component: FormTemplateManager
            },

            {
                path: '/eligibilityChecks',
                name: 'EligibilityCheckManager',
                component: EligibilityCheckManager
            },

            {
                path: '/externalData',
                name: 'ExternalDataManager',
                component: ExternalDataManager
            },

            {
                path: '/applicationDocuments',
                name: 'ApplicationDocumentManager',
                component: ApplicationDocumentManager
            },

            {
                path: '/issuedDocuments',
                name: 'IssuedDocumentManager',
                component: IssuedDocumentManager
            },



    ]
})
