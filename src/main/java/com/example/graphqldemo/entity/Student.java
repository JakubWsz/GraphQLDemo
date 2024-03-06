package com.example.graphqldemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name="age")
	private int age;

	@Column(name = "index_number", unique = true)
	private String indexNumber;

	public Student(String firstName, String lastName, String indexNumber,int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.indexNumber = indexNumber;
	}
}
