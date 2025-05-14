package com.study.todo.domain.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateTodoRequestDto {

	@NotBlank
	private final String title;

	private final String content;

	public UpdateTodoRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
