#!/bin/bash
source ~/gcp/env_vars.txt

gcloud pubsub topics create myTopic
gcloud pubsub topics list

gcloud pubsub subscriptions create mySubscription --topic myTopic
gcloud pubsub subscriptions list	