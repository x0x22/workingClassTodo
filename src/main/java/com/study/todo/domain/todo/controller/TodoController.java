package com.study.todo.domain.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.study.todo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.study.todo.domain.todo.dto.response.AllTodoResponseDto;
import com.study.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.study.todo.domain.todo.dto.response.ToDoResponseDto;
import com.study.todo.domain.todo.dto.response.UpdateTodoResponseDto;
import com.study.todo.domain.todo.service.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;

	// 생성
	@PostMapping
	public ResponseEntity<CreateTodoResponseDto> createTodo(@RequestBody @Valid CreateTodoRequestDto requestDto){
		CreateTodoResponseDto todo = todoService.createTodo(requestDto);
		return new ResponseEntity<>(todo, HttpStatus.CREATED);
	}

	// 단일 조회
	@GetMapping("/{todoId}")
	public ResponseEntity<ToDoResponseDto> todoInfo(@PathVariable Long todoId){
		ToDoResponseDto toDoResponseDto = todoService.todoInfo(todoId);
		return new ResponseEntity<>(toDoResponseDto,HttpStatus.OK);
	}

	// 전체 조회
	@GetMapping
	public ResponseEntity<List<AllTodoResponseDto>> todoList(){
		List<AllTodoResponseDto> allTodoList = todoService.todoList();
		return new ResponseEntity<>(allTodoList,HttpStatus.OK);
	}

	// 단건 수정
	@PatchMapping("/{todoId}")
	public ResponseEntity<UpdateTodoResponseDto> updateTodo(
		@PathVariable Long todoId,
		@RequestBody @Valid UpdateTodoRequestDto dto){
		UpdateTodoResponseDto UpdateDto = todoService.updateTodo(todoId, dto);
		return new ResponseEntity<>(UpdateDto,HttpStatus.OK);
	}

	// 단건 삭제
	@DeleteMapping("/{todoId}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId){
		todoService.deleteTodo(todoId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
