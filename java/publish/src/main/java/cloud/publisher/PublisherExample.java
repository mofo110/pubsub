package cloud.publisher;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

public class PublisherExample {

  // use the default project id
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();

  /** Publish messages to a topic.
   * @param args topic name, number of messages
   */
  public static void main(String... args) throws Exception {
    // topic id, eg. "myTopic"
    String topicId = args[0];
    int messageCount = Integer.parseInt(args[1]);
    TopicName topicName = TopicName.of(PROJECT_ID, topicId);
    Publisher publisher = null;
    try {
      // Create a publisher instance with default settings bound to the topic
      publisher = Publisher.newBuilder(topicName).build();

      for (int i = 0; i < messageCount; i++) {
        String message = "message-" + i;

        // convert message to bytes
        ByteString data = ByteString.copyFromUtf8(message);
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
            .setData(data)
            .build();

        //schedule a message to be published, messages are automatically batched
        ApiFuture<String> future = publisher.publish(pubsubMessage);

        // add an asynchronous callback to handle success / failure
        ApiFutures.addCallback(future, new ApiFutureCallback<String>() {

          @Override
          public void onFailure(Throwable throwable) {
            if (throwable instanceof ApiException) {
              ApiException apiException = ((ApiException) throwable);
              // details on the API exception
              System.out.println(apiException.getStatusCode().getCode());
              System.out.println(apiException.isRetryable());
            }
            System.out.println("Error publishing message : " + message);
          }

          @Override
          public void onSuccess(String messageId) {
            // Once published, returns server-assigned message ids (unique within the topic)
            System.out.println(messageId);
          }
        });
      }
    } finally {
      if (publisher != null) {
        // When finished with the publisher, shutdown to free up resources.
        publisher.shutdown();
      }
    }
  }
}
