package com.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String category;
	private Set<User> user;
	public int getId() {
		return id;
	}
	
	public Category(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}
	@OneToMany(fetch=FetchType.EAGER, targetEntity=User.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "user", referencedColumnName="username")
	public Set<User> getUser() {
		return user;
	}
	public Category(int id, String category, Set<User> user) {
		super();
		this.id = id;
		this.category = category;
		this.user = user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + ", user=" + user + "]";
	}
	

}
