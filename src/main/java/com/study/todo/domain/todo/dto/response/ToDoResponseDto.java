package com.study.todo.domain.todo.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.todo.domain.comment.dto.response.CommentResponseDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ToDoResponseDto {

	private final Long id;
	private final String title;
	private final String content;
	private final int countComment;

	private final List<CommentResponseDto> commentList;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime createdAt;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime updatedAt;

}
