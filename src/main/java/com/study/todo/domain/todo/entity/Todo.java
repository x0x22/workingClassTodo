package com.study.todo.domain.todo.entity;

import java.util.List;

import com.study.todo.common.entity.BaseEntity;
import com.study.todo.domain.comment.entity.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Todo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	@OneToMany(mappedBy = "todo")
	private List<Comment> commentList;

	@Builder
	public Todo(String title,String content) {
		this.title = title;
		this.content = content;
	}

	public void updateTodo(String title,String content){
		this.title = title;
		this.content = content;
	}
}
