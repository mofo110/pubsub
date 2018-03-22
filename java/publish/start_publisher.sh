#!/bin/bash
source ~/gcp/env_vars.txt

java -jar ./build/libs/cloud-publisher.jar myTopic 1
