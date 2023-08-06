package com.example.springbootapplication.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String home() {
        //var tasks = taskService.getTasks();

        return "test application";
    }
}
