package com.study.todo.domain.comment.service;

import com.study.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.study.todo.domain.comment.dto.response.CommentInfoResponseDto;
import com.study.todo.domain.comment.dto.response.CreateCommentResponseDto;

public interface CommentService {

	// 생성
	CreateCommentResponseDto createComment(CreateCommentRequestDto dto);

	// 단건 조회(부모 댓글 포함)
	CommentInfoResponseDto CommentInfo(Long id);

}
