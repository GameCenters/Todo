package com.GameCenter.todo.repositroy;

import com.GameCenter.todo.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
//데이터 베이스와 관련된 인터페이스
//JpaRepository를 상속받아 <데이터베이스 연결 객체,객체의 id 타입>을 통해서 데이터베이스를 연결시킵니다
public interface TodoListRepository extends JpaRepository<TodoList,Integer> { }
