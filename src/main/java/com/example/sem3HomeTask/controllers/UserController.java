package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() { return registrationService.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/registration") //localhost:8080/user/registration Post запрос
    public String usersAddFromRepo(@RequestBody List <User> users) { //добавление переданного списка пользователей из репозитория
        for (User user : users) {
            registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        }
        return "users has added from repository";
    }
//    @PostMapping("/body")
//    public String userAddFromBody(@RequestBody User user)
//    {
//        service.getDataProcessingService().getRepository().getUsers().add(user);
//        return "User added from body!";
//    }
}
