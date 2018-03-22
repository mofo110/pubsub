#!/bin/bash
source ~/gcp/env_vars.txt

gcloud pubsub subscriptions delete ${MY_SUBSCRIPTION}
gcloud pubsub subscriptions list

gcloud pubsub topics delete ${MY_TOPIC}
gcloud pubsub topics list
