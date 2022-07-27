package com.GameCenter.todo.service;

import com.GameCenter.todo.entity.TodoList;
import com.GameCenter.todo.entity.TodoListDTO;
import com.GameCenter.todo.repositroy.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired //타입에 해당하는 빈을 찾아 주입
    private TodoListRepository todoListRepository;

    public List<TodoList> TodoList(){
        return todoListRepository.findAll();
    }

    public TodoList TodoListAdd(TodoListDTO DTO){
        TodoList todoList = new TodoList(DTO.getTitle(), DTO.getDate(),DTO.getComplete());
        return todoListRepository.save(todoList);
    }
}
