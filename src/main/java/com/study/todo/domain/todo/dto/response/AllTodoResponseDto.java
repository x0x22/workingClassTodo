package com.study.todo.domain.todo.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AllTodoResponseDto {

	private final Long id;
	private final String title;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime updatedAt;
}
