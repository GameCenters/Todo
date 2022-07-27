package com.GameCenter.todo.service;

import com.GameCenter.todo.repositroy.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired //타입에 해당하는 빈을 찾아 주입
    private TodoListRepository todoListRepository;
}
