package com.GameCenter.todo.controller;

import com.GameCenter.todo.dto.Message;
import com.GameCenter.todo.service.QueryTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //객체를 반환 데이터를 JSON이나 XML으로 보냄 Controller + ResponseBody
public class QueryTodoController {

    @Autowired
    private QueryTodoService todoService;
    private Message message;

    //ResponseEntity 데이터와 HTTP 상태코드를 지정하는 클래스
    @GetMapping("/")
    public ResponseEntity list(){
        return new ResponseEntity(new Message(HttpStatus.OK.value(),"조회 완료",todoService.allGetTodo(),
                                  todoService.allGetTodo().size()),HttpStatus.OK);
    }
}
