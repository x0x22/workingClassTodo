package com.study.todo.domain.comment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.study.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.study.todo.domain.comment.entity.Comment;
import com.study.todo.domain.comment.repository.CommentRepository;
import com.study.todo.domain.todo.entity.Todo;
import com.study.todo.domain.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentRepository commentRepository;
	private final TodoRepository todoRepository;

	@Transactional
	@Override
	public CreateCommentResponseDto createComment(CreateCommentRequestDto dto) {

		Todo todo = todoRepository.findById(dto.getTodoId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 일정입니다."));

		Comment parent = null;
		if (dto.getParentId() != null){
			parent = commentRepository.findById(dto.getParentId())
				.orElseThrow(()->new IllegalArgumentException("부모 댓글이 존재하지 않습니다."));
		}

		Comment comment = Comment.builder()
			.todo(todo)
			.content(dto.getContent())
			.parent(parent)
			.build();

		Comment save = commentRepository.save(comment);

		return CreateCommentResponseDto.builder()
			.id(save.getId())
			.content(save.getContent())
			.parentId(parent != null ? parent.getId() : null)
			.createdAt(save.getCreatedAt())
			.build();
	}
}
