package com.study.todo.domain.todo.entity;

import com.study.todo.common.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
