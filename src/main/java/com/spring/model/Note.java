package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Note {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String note;
	public int getId() {
		return id;
	}
	
	public Note(int id, String note) {
		super();
		this.id = id;
		this.note = note;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Category getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + "]";
	}
	

}
