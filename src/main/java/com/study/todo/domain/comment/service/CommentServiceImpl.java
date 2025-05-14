package com.study.todo.domain.comment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.study.todo.domain.comment.dto.response.CommentInfoResponseDto;
import com.study.todo.domain.comment.dto.response.CommentResponseDto;
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

			if (parent.getParent() != null) {
				throw new IllegalArgumentException("대댓글에 대댓글은 작성할 수 없습니다.");
			}
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

	@Override
	public CommentInfoResponseDto CommentInfo(Long commentId) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

		Comment parent = (comment.getParent() != null) ? comment.getParent() : comment;

		List<Comment> replies = commentRepository.findByParent(parent);

		List<CommentInfoResponseDto> replyDtos = new ArrayList<>();
		for (Comment reply : replies) {
			replyDtos.add(new CommentInfoResponseDto(
				reply.getId(),
				reply.getContent(),
				reply.getCreatedAt(),
				reply.getUpdatedAt(),
				reply.getParent() != null ? reply.getParent().getId() : null,
				Collections.emptyList()
			));
		}

		return new CommentInfoResponseDto(
			parent.getId(),
			parent.getContent(),
			parent.getCreatedAt(),
			parent.getUpdatedAt(),
			null,
			replyDtos
		);
	}
}
