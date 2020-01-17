package com.example.demo.controller;

import com.example.demo.entity.NotificationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.bus.Event;
import reactor.bus.EventBus;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String projectName;

    @Autowired
    private EventBus eventBus;


    @GetMapping("/test/{param}")
    public void startNotification(@PathVariable Integer param){

        for (int i = 0; i < param; i++) {
            NotificationData notificationData = new NotificationData();
            notificationData.setId(i);

            eventBus.notify("notificationConsumer", Event.wrap(notificationData));

            System.out.println("Notification " + i + ":notification task submitted successfully");
        }

    }
}
