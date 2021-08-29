package com.example.demo.controller;

import com.example.demo.service.EventSubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

  @Autowired
  EventSubscriberService es;

  @RequestMapping("/")
  public void hello(HttpServletResponse response) throws IOException {
    response.getWriter().print("working");
  }

  @RequestMapping("/stop")
  public void step(HttpServletResponse response) throws IOException {
    es.stop();
    response.getWriter().print("stopped");
  }

}