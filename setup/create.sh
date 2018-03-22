#!/bin/bash
source ~/gcp/env_vars.txt

gcloud pubsub topics create ${MY_TOPIC}
gcloud pubsub topics list

gcloud pubsub subscriptions create ${MY_SUBSCRIPTION} --topic ${MY_TOPIC}
gcloud pubsub subscriptions list	
