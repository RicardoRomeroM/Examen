package com.example.examenRicardo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="employee")
public class Employee {
	@Id //Llave primaria de la tabla
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;

	@Column(name = "surname")
	private String surname;
	
	@Column(name = "firsname")
	private String firsname;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirsname() {
		return firsname;
	}

	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}
}
