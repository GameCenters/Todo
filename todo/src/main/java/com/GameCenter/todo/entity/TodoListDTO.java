package com.GameCenter.todo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoListDTO {
    private String title;
    private String date;
    private String complete;
}
