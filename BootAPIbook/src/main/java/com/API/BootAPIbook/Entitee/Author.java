package com.API.BootAPIbook.Entitee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String First_name;
	private String last_name;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int id, String first_name, String last_name) {
		super();
		this.id = id;
		First_name = first_name;
		this.last_name = last_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", First_name=" + First_name + ", last_name=" + last_name + "]";
	}

}
