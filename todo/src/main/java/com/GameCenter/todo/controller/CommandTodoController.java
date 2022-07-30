package com.GameCenter.todo.controller;

import com.GameCenter.todo.dto.ErrorMessage;
import com.GameCenter.todo.dto.TodoListDTO;
import com.GameCenter.todo.service.CommandTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommandTodoController {

    @Autowired
    private CommandTodoService commandTodoService;

    @PostMapping("/todo")
    public ResponseEntity todoAdd(@RequestBody TodoListDTO DTO){
        return new ResponseEntity(commandTodoService.addTodo(DTO),HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity todoUpdate(@PathVariable int id, @RequestBody TodoListDTO DTO){
        return new ResponseEntity(commandTodoService.updateTodo(id,DTO),HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity todoDelete(@PathVariable int id){
        commandTodoService.deleteTodo(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/todos")
    public ResponseEntity todoDelete(){
        commandTodoService.allDeleteTodo();
        return new ResponseEntity(HttpStatus.OK);
    }
}