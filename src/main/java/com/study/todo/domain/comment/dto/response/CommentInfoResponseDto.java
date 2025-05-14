package com.study.todo.domain.comment.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter

public class CommentInfoResponseDto {

	private final Long id;
	private final String content;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime updatedAt;

	private final Long parentId;
	private final List<CommentInfoResponseDto> replies;

	public CommentInfoResponseDto(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Long parentId,
		List<CommentInfoResponseDto> replies) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.parentId = parentId;
		this.replies = replies;
	}
}
