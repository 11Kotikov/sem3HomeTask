package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort") // localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(dataProcessingService.getRepository().getUsers());
    }

    @GetMapping("/filter/{age}") // localhost:8080/tasks/filter/{age}
    public List<User> filterUsersByAge(@PathVariable int age) {
        return dataProcessingService.filterUsersByAge(dataProcessingService.getRepository().getUsers(), age);
    }

    @GetMapping("/calc") // localhost:8080/tasks/calc
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(dataProcessingService.getRepository().getUsers());
    }
}
    /*
    todo
     1. метод filterUsersByAge (Подсказка  @GetMapping("/filter/{age}"))
     2. calculateAverageAge (Подсказка  @GetMapping("/calc"))

     */


