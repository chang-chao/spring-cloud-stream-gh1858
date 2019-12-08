package me.changchao.springcloud.springcloudstreamgh1858;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputStream {
  @Input("foo")
  SubscribableChannel subscribe();
}
