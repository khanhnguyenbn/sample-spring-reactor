package com.example.demo.service;

import com.example.demo.entity.NotificationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class NotificationConsumer implements Consumer<Event<NotificationData>> {

    @Autowired
    private NotificationService notificationService;

    @Override
    public void accept(Event<NotificationData> notificationDataEvent) {

        NotificationData notificationData = notificationDataEvent.getData();

        try {
            notificationService.initiateNotification(notificationData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
