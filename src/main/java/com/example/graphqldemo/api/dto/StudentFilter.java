package com.example.graphqldemo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentFilter {
	private String firstName;
	private String lastName;
	private String indexNumber;
	private List<String> nameIn;
	private String nameContains;
	private Integer ageGreater;
	private Integer ageLess;
	private Integer ageEquals;
	private Integer minAge;
	private Integer maxAge;
}
