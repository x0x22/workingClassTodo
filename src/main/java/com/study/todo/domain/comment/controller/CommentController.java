package com.study.todo.domain.comment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.study.todo.domain.comment.dto.response.CommentInfoResponseDto;
import com.study.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.study.todo.domain.comment.service.CommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos/{todoId}/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// 댓글 생성
	@PostMapping
	public ResponseEntity<CreateCommentResponseDto> createComment(@RequestBody @Valid
		CreateCommentRequestDto dto){
		CreateCommentResponseDto comment = commentService.createComment(dto);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	// 댓글 조회
	@GetMapping("/{commentId}")
	public ResponseEntity<CommentInfoResponseDto> commentInfo(@PathVariable Long commentId) {

		CommentInfoResponseDto commentInfo = commentService.CommentInfo(commentId);
		return new ResponseEntity<>(commentInfo, HttpStatus.OK);
	}
}
