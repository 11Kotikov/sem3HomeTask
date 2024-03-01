package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.FileGateway;
import com.example.sem3HomeTask.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")//localhost:8080/user
public class UserController {

    private RegistrationService registrationService;
    @Autowired
    private final FileGateway fileGateway;


    @GetMapping
    public List<User> userList() { return registrationService.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/registration") //localhost:8080/user/registration Post запрос
    public String usersAddFromRepo(@RequestBody List <User> users) { //добавление переданного списка пользователей из репозитория
        for (User user : users) {
            registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        }
        return "users has added from repository";
    }

    /*
    метод добавляет только одного пользователя и
    сохраняет его в файл
     */
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        fileGateway.writeToFile(user.getName() + ".txt", user.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/body")
//    public String userAddFromBody(@RequestBody User user)
//    {
//        service.getDataProcessingService().getRepository().getUsers().add(user);
//        return "User added from body!";
//    }
}
