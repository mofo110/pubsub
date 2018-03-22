#!/bin/bash
source ~/gcp/env_vars.txt

gcloud pubsub subscriptions delete mySubscription
gcloud pubsub subscriptions list

gcloud pubsub topics delete myTopic
gcloud pubsub topics list
