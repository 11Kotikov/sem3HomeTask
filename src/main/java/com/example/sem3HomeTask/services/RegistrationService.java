package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    /*
    Метод для регистрации нового пользователя.
    Создает нового пользователя и добавляет его в репозиторий через DataProcessingService.
     */
    public void processRegistration(String name, int age, String email) {
        // Создание пользователя из переданных параметров
        User user = userService.createUser(name, age, email);
        // Добавление нового пользователя в репозиторий через DataProcessingService
        dataProcessingService.addUserToList(user);
        // Вывод сообщения через notificationService
        notificationService.notifyUser(user);
    }
}

/*
todo
 1. Добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
 2.  Реализовать метод processRegistration() класса RegistrationService.
 */