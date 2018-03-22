# Google Cloud Pub/Sub Sample - Node.js

This is my sample implementation of the Google Cloud Pub/Sub Node.js client library.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Google Cloud service account with Pub/Sub role
* Google Cloud SDK
* Google Cloud Pub/Sub Client Libraries
* Java or Node.js or Python

### Private Key File

Save your private key file as ~/gcp/keyfile.json.

### Configuration

Create a ~/gcp/env_vars.txt file with some basic environment variables:
```
export GOOGLE_APPLICATION_CREDENTIALS=~/gcp/keyfile.json
export SERVICE_ACCOUNT=[your service account email]
export PROJECT_ID=[your project id]
```

### Installing/Building

#### Java

In the ./pubsub/java/publish and ./pubsub/java/subscribe directories, build the jar

```
./gradlew clean build
```

#### Node.js

In the ./pubsub/node/publish and ./pubsub/node/subscribe directories, install the client libraries

```
npm install --save @google-cloud/pubsub
```

#### Python

Install the client libraries.  Please refer to [Python Development Environment Setup Guide](https://cloud.google.com/python/setup).

```
pip install --upgrade google-cloud-pubsub
```

### Login

Run the ./pubsub/setup/login.sh.

```
Activated service account credentials for: ${SERVICE_ACCOUNT}
```

## Running the tests

* Setup
* Publish
* Subscribe
* Teardown

### Setup

Run the ./pubsub/setup/create.sh script to create a topic and subscription.
```
Created topic [projects/${PROJECT_ID}/topics/myTopic].
---
name: projects/${PROJECT_ID}/topics/myTopic
Created subscription [projects/${PROJECT_ID}/subscriptions/mySubscription].
---
ackDeadlineSeconds: 10
messageRetentionDuration: 604800s
name: projects/${PROJECT_ID}/subscriptions/mySubscription
pushConfig: {}
topic: projects/${PROJECT_ID}/topics/myTopic
```

### Publish

Run the ./pubsub/[java|node|python]/publish/start_publisher.sh script to publish a message.

#### Node sample output:

```
Message 57081909257453 published.
```

### Subscribe

Run ./pubsub/[java|node|python]/subscribe/start_subscriber.sh script to start the subscriber.

#### Node sample output:

```
Received message 57081909257453:
	Data: {"Greeting":"Hello World!"}
	Attributes: [object Object]
1 message(s) received.
```

### Teardown

Run the ./pubsub/teardown/destroy.sh script to cleanup the subscription and topic.
```
Deleted subscription [projects/${PROJECT_ID}/subscriptions/mySubscription].
Listed 0 items.
Deleted topic [projects/${PROJECT_ID}/topics/myTopic].
Listed 0 items.
```

## Built With

* [GCP SDK](https://cloud.google.com/sdk/docs/) - Google Cloud SDK
* [GCP Pub/Sub](https://cloud.google.com/pubsub/docs/) - Google Cloud Pub/Sub

## Authors

* **mofo110** - *Initial work* - [mofo110](https://github.com/mofo110)