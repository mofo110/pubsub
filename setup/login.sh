#!/bin/bash
source ~/gcp/env_vars.txt

gcloud auth activate-service-account ${SERVICE_ACCOUNT} --key-file=${GOOGLE_APPLICATION_CREDENTIALS} --project ${PROJECT_ID}
