package com.example.demo;

import com.example.demo.service.EventSubscriberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class Demo2Application {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(Demo2Application.class, args);
    Thread subscriber = new Thread(ctx.getBean(EventSubscriberService.class));
    log.info("Starting Subscriber Thread");
    subscriber.run();
  }

}
