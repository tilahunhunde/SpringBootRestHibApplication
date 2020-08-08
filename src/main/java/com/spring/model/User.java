package com.spring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@Column
	private String password;
	 @ManyToMany
	private Set<Note> note;
	 
	public Set<Note> getNote() {
		return note;
	}

	public void setNote(Set<Note> note) {
		this.note = note;
	}

	public int getUserId() {
		return userId;
	}
	
	public User(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	

	public User(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public User(int userId, String userName, String password, Set<Note> note) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.note = note;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	

}
