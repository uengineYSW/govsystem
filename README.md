# 

## Model
www.msaez.io/#/112850933/storming/gov-system20240224-1

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- ServiceApplication
- EligibilityVerification
- DataCollection
- ApplicationDocument
- DocumentIssuance


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- ServiceApplication
```
 http :8088/serviceApplications applicationId="applicationId"User := '{"userId": userId, "userName": userName, "email": email}'serviceType="serviceType"formData="formData"attachment="attachment"ProgressStatus = "TEMPORARY"
 http :8088/formTemplates templateId="templateId"formType="formType"version="version"mappingRule="mappingRule"previewContent="previewContent"alternativeTemplate="alternativeTemplate"
```
- EligibilityVerification
```
 http :8088/eligibilityChecks eligibilityCheckId="eligibilityCheckId"QualificationStatus = "QUALIFIED"InquiryHistoryItem := '{"inquiryId": inquiryId, "applicantId": applicantId, "residentRegistrationNumber": residentRegistrationNumber, "foreignerRegistrationNumber": foreignerRegistrationNumber, "rejectionReason": rejectionReason, "inquiryTime": null, "qualificationStatus": undefined}'ServiceApplicationId := '{"applicationId": applicationId}'
```
- DataCollection
```
 http :8088/externalData collectionId="collectionId"systemName="systemName"queryItems="queryItems"queryPeriod="queryPeriod"priority="priority"dataProcessingRules="dataProcessingRules"DataVerificationStatus = "VALID"QueryHistoryItem := '{"historyId": historyId, "queryTime": null}'
```
- ApplicationDocument
```
 http :8088/applicationDocuments documentId="documentId"ApplicationFormData := '{"templateCode": templateCode, "signaturePosition": signaturePosition, "attachments": attachments}'electronicSignatureData="electronicSignatureData"DraftHistoryRecord := '{"draftTime": null, "editedBy": editedBy}'SecurityRating = "Low"ServiceApplicationId := '{"applicationId": applicationId}'FormTemplateId := '{"templateId": templateId}'
```
- DocumentIssuance
```
 http :8088/issuedDocuments documentId="documentId"EdmsIntegrationInfo := '{"systemIntegration": systemIntegration, "documentClassification": documentClassification, "securityLevel": securityLevel, "retentionPeriod": 0}'PdfProcessingInfo := '{"template": template, "font": font, "margin": 0, "resolution": resolution, "encryptionLevel": encryptionLevel, "outputControl": false, "watermarkPosition": watermarkPosition, "securityLevel": securityLevel}'EligibilityCheckId := '{"eligibilityCheckId": eligibilityCheckId}'ExternalDataId := '{"collectionId": collectionId}'ApplicationDocumentId := '{"documentId": 0}'
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
