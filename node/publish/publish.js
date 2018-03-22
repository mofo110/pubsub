// Imports the Google Cloud client library
const PubSub = require(`@google-cloud/pubsub`);

// Creates a client
const pubsub = new PubSub();

/**
 * TODO(developer): Uncomment the following lines to run the sample.
 */
const topicName = process.env['MY_TOPIC'];
const data = JSON.stringify({ Greeting: 'Hello World!' });

// Publishes the message as a string, e.g. "Hello, world!" or JSON.stringify(someObject)
const dataBuffer = Buffer.from(data);

pubsub
  .topic(topicName)
  .publisher()
  .publish(dataBuffer)
  .then(results => {
    const messageId = results;
    console.log(`Message ${messageId} published.`);
  })
  .catch(err => {
    console.error('ERROR:', err);
  });