package com.study.todo.domain.comment.service;

import com.study.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.study.todo.domain.comment.dto.response.CreateCommentResponseDto;

public interface CommentService {

	CreateCommentResponseDto createComment(CreateCommentRequestDto dto);

}
