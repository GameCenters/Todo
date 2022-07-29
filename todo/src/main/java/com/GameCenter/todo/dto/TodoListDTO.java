package com.GameCenter.todo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TodoListDTO {
    private String title;
    private String date;
    private String complete;
}
