package com.GameCenter.todo.controller;

import com.GameCenter.todo.entity.TodoListDTO;
import com.GameCenter.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //객체를 반환 데이터를 JSON이나 XML으로 보냄 Controller + ResponseBody
public class TodoController {

    @Autowired
    private TodoService todoService;

    //ResponseEntity 데이터와 HTTP 상태코드를 지정하는 클래스
    @GetMapping("/")
    public ResponseEntity list(){
        return new ResponseEntity(todoService.TodoList(),HttpStatus.OK);
    }

    @PostMapping("/Post")
    public ResponseEntity todoAdd(@RequestBody TodoListDTO DTO){
        return new ResponseEntity(todoService.TodoListAdd(DTO),HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity todoUpdate(@PathVariable int id,@RequestBody TodoListDTO DTO){
        return new ResponseEntity(todoService.TodoListUpdate(id,DTO),HttpStatus.OK);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity todoDelete(@PathVariable int id){
        todoService.TodoListDelete(id);
        return new ResponseEntity(todoService.TodoList(),HttpStatus.OK);
    }

    @DeleteMapping("/AllDelete")
    public ResponseEntity todoDelete(){
        todoService.TodoListAllDelete();
        return new ResponseEntity(todoService.TodoList(),HttpStatus.OK);
    }
}
