package com.polytech.todolist.models;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
	@Id
    @Column(name = "username")
    private String username;
	
	@Column(name = "password")
	private String password;
	    
	@Column(name = "firstname")
    private String firstname;

  
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name="enabled")
    private boolean enabled;
    
    public Users() {
    	
    }
    public Users(String username, String password,String firstname,String lastname, boolean e) {
    	this.firstname=firstname;
    	this.lastname=lastname;
    	this.username=username;
    	this.password=password;
    	this.enabled=e;
    	
    }
	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean s) {
		this.enabled=s;
	}
	
    
}
