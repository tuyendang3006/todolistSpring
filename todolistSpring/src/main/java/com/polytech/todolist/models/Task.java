package com.polytech.todolist.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "done")
	private boolean done;
	
	@Column(name = "username")
	private String username;
	
	public Task() {
		
	}
	public Task(String content,String username) {
		this.content=content;
		this.done=false;
		this.username=username;
	}
	public Task(Long id,String content,boolean done,String username) {
		this.id=id;
		this.content=content;
		this.done=done;
		this.username=username;
	}
	
	public Task(Long id, String content,String username) {
		this.id=id;
		this.content=content;
		this.username=username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
