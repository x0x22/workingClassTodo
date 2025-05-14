package com.study.todo.domain.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.todo.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {

	List<Comment> findByParent(Comment parent);

}
