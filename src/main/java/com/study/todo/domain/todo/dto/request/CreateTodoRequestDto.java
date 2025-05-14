package com.study.todo.domain.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTodoRequestDto {

	@NotBlank
	private final String title;

	private final String content;

}
