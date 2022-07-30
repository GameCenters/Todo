package com.GameCenter.todo.service;

import com.GameCenter.todo.entity.TodoList;
import com.GameCenter.todo.dto.TodoListDTO;
import com.GameCenter.todo.repositroy.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandTodoService {

    @Autowired
    private TodoListRepository todoListRepository;

    public TodoList addTodo(TodoListDTO DTO){
        TodoList todoList = new TodoList();
        todoList.setTitle(DTO.getTitle());
        todoList.setDate(DTO.getDate());
        todoList.setComplete(DTO.getComplete());

        return todoListRepository.save(todoList);
    }

    public TodoList updateTodo(int id,TodoListDTO DTO){
        //id와 일치하는 모든 데이터를 가져옴
        TodoList todo = todoListRepository.findById(id).get();
        todo.setTitle(DTO.getTitle());
        todo.setDate(DTO.getDate());
        todo.setComplete(DTO.getComplete());
        todoListRepository.save(todo);

        return todo;
    }

    public void deleteTodo(int id){
        todoListRepository.deleteById(id);
    }

    public void allDeleteTodo(){
        todoListRepository.deleteAll();
    }
}
