package me.changchao.springcloud.springcloudstreamgh1858;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InputStreamService {
  @StreamListener("foo")
  public void process(@Payload String payload) {
    System.out.println(payload);
  }
}
