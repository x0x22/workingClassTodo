package com.study.todo.domain.comment.service;

import com.study.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.study.todo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.study.todo.domain.comment.dto.response.CommentInfoResponseDto;
import com.study.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.study.todo.domain.comment.dto.response.UpdateCommentResponseDto;

public interface CommentService {

	// 생성
	CreateCommentResponseDto createComment(Long todoId, CreateCommentRequestDto dto);

	// 단건 조회(부모 댓글 포함)
	CommentInfoResponseDto CommentInfo(Long id);

	// 수정
	UpdateCommentResponseDto updateComment(Long commentId, UpdateCommentRequestDto dto);

	// 댓글 삭제
	void deleteComment(Long todoId,Long commentId);

}
