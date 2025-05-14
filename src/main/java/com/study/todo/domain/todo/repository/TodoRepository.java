package com.study.todo.domain.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.todo.domain.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
