package com.study.todo.domain.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.todo.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {

	List<Comment> findByParent(Comment parent);

	@Query("SELECT COUNT(c) FROM Comment c WHERE c.todo.id = :todoId")
	int countCommentsByTodoId(@Param("todoId") Long todoId);
}
