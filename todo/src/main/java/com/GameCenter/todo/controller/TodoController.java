package com.GameCenter.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

    @GetMapping("/")
    @ResponseBody
    public String Hello(){
        return "Hello Spring";
    }
}
