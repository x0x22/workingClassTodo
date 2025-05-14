package com.study.todo.domain.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.study.todo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.study.todo.domain.todo.dto.response.AllTodoResponseDto;
import com.study.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.study.todo.domain.todo.dto.response.ToDoResponseDto;
import com.study.todo.domain.todo.dto.response.UpdateTodoResponseDto;
import com.study.todo.domain.todo.entity.Todo;
import com.study.todo.domain.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoRepository todoRepository;

	//생성
	@Transactional
	@Override
	public CreateTodoResponseDto createTodo(CreateTodoRequestDto dto) {

		Todo todo = Todo.builder()
			.title(dto.getTitle())
			.content(dto.getContent())
			.build();
		Todo saved = todoRepository.save(todo);

		return CreateTodoResponseDto.builder()
			.id(saved.getId())
			.title(saved.getTitle())
			.content(saved.getContent())
			.createdAt(saved.getCreatedAt())
			.build();

	}

	// 단일 조회
	@Override
	public ToDoResponseDto todoInfo(Long todoId) {
		Todo findTodo = todoRepository.findById(todoId)
			.orElseThrow(()->new IllegalArgumentException("존재하지 않는 일정입니다."));

		return ToDoResponseDto.builder()
			.id(findTodo.getId())
			.title(findTodo.getTitle())
			.content(findTodo.getContent())
			.createdAt(findTodo.getCreatedAt())
			.updatedAt(findTodo.getUpdatedAt())
			.build();
	}

	// 전체 목록 조회
	@Override
	public List<AllTodoResponseDto> todoList() {
		List<Todo> allTodos = todoRepository.findAll();

		return allTodos.stream()
			.map(todo -> AllTodoResponseDto.builder()
				.id(todo.getId())
				.title(todo.getTitle())
				.createdAt(todo.getCreatedAt())
				.updatedAt(todo.getUpdatedAt())
				.build())
			.collect(Collectors.toList());
	}

	// 단건 수정
	@Transactional
	@Override
	public UpdateTodoResponseDto updateTodo(Long todoId, UpdateTodoRequestDto dto) {

		Todo todo = todoRepository.findById(todoId)
			.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 일정입니다."));
		todo.updateTodo(dto.getTitle(),dto.getContent());

		return UpdateTodoResponseDto.builder()
			.id(todo.getId())
			.content(todo.getContent())
			.title(todo.getTitle())
			.createdAt(todo.getCreatedAt())
			.updatedAt(todo.getUpdatedAt())
			.build();
	}

	// 삭제
	@Transactional
	@Override
	public void deleteTodo(Long id) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(()-> new IllegalArgumentException("존재하지 않는 일정입니다."));
		todoRepository.delete(todo);
	}

}
