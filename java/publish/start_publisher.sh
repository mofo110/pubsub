#!/bin/bash
source ~/gcp/env_vars.txt

java -jar ./build/libs/publish.jar ${MY_TOPIC} 1
