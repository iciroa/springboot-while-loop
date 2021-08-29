package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public
class EventSubscriberService implements DisposableBean, Runnable {

  private Thread thread;
  private volatile boolean someCondition;
  private int cnt = 0;

  public EventSubscriberService() {
    this.thread = new Thread(this);
    this.thread.start();
  }

  @Override
  public void run() {
    someCondition = true;
    while (someCondition) {
      try {
        log.info("cnt : {}", cnt);
        cnt += 1;
        thread.sleep(1000);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void stop() {
    someCondition = false;
  }

  @Override
  public void destroy() {
    someCondition = false;
  }

}