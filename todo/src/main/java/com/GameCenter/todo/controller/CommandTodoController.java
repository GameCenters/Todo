package com.GameCenter.todo.controller;

import com.GameCenter.todo.dto.Message;
import com.GameCenter.todo.dto.TodoListDTO;
import com.GameCenter.todo.service.CommandTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CommandTodoController {

    @Autowired
    private CommandTodoService todoService;

    @PostMapping("/Post")
    public ResponseEntity todoAdd(@RequestBody TodoListDTO DTO){
        return new ResponseEntity(new Message(HttpStatus.CREATED.value(),"생성 완료",todoService.addTodo(DTO),null),HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity todoUpdate(@PathVariable int id, @RequestBody TodoListDTO DTO){
        return new ResponseEntity(new Message(HttpStatus.OK.value(),"수정 완료",todoService.updateTodo(id,DTO),null),HttpStatus.OK);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity todoDelete(@PathVariable int id){
        todoService.deleteTodo(id);
        return new ResponseEntity(new Message(HttpStatus.OK.value(),id + "번 삭제 완료",null,null),HttpStatus.OK);
    }

    @DeleteMapping("/AllDelete")
    public ResponseEntity todoDelete(){
        todoService.allDeleteTodo();
        return new ResponseEntity(new Message(HttpStatus.OK.value(),"삭제 완료",null,null),HttpStatus.OK);
    }
}
