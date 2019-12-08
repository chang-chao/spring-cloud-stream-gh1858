package me.changchao.springcloud.springcloudstreamgh1858;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.AbstractMessageChannelBinder;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(InputStream.class)
public class SpringCloudStreamGh1858Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudStreamGh1858Application.class, args);
  }

  //  @StreamListener(Sink.INPUT)
  public void process(Message<?> message) {
    Object payload = message.getPayload();
    System.out.println(payload);
    Acknowledgment acknowledgment =
        message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    if (acknowledgment != null) {
      System.out.println("Acknowledgment provided");
      acknowledgment.acknowledge();
    }
  }
}
