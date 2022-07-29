package com.GameCenter.todo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor// 필드의 모든값을 받는 생성자 생성
@JsonInclude(JsonInclude.Include.NON_NULL)//JSON 반환시 null값을 가지는 값은 제외
public class Message {
    private int status;
    private String message;
    private Object data;
    private Integer count;
}
