package com.polytech.todolist.models;

import javax.persistence.*;

@Entity
@Table(name = "Authorities")
public class Authorities {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="authority")
	private String authority;
	
	public Authorities() {
		
	}
	public Authorities(String username,String authority) {
		this.username=username;
		this.authority=authority;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
