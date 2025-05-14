package com.study.todo.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCommentRequestDto {

	private final Long todoId;

	@NotBlank
	private final String content;

	private final Long parentId;

}
