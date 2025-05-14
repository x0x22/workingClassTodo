package com.study.todo.domain.todo.service;

import java.util.List;

import com.study.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.study.todo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.study.todo.domain.todo.dto.response.AllTodoResponseDto;
import com.study.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.study.todo.domain.todo.dto.response.ToDoResponseDto;
import com.study.todo.domain.todo.dto.response.UpdateTodoResponseDto;
import com.study.todo.domain.todo.entity.Todo;

public interface TodoService {
	// 생성
	CreateTodoResponseDto createTodo(CreateTodoRequestDto dto);
	// 단일 조회
	ToDoResponseDto todoInfo(Long id);
	// 전체 조회
	List<AllTodoResponseDto> todoList();
	// 일정 수정
	UpdateTodoResponseDto updateTodo(Long id,UpdateTodoRequestDto dto);
	// 일정 삭제
	void deleteTodo(Long id);
}
