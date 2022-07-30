package com.GameCenter.todo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data//Getter,Setter등 기본적인 필드 메소드 생성
@Entity//Entity 클래스로 지정하여 DB 테이블과 매핑
@NoArgsConstructor//기본 생성자 생성
public class TodoList {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String complete;
}
