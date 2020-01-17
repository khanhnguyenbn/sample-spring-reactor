package com.example.demo.service;

import com.example.demo.entity.NotificationData;

public interface NotificationService {

    void initiateNotification(NotificationData notificationData) throws InterruptedException;
}
