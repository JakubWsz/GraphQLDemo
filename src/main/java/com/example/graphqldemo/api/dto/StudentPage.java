package com.example.graphqldemo.api.dto;

import com.example.graphqldemo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentPage {
	private List<Student> content;
	private int totalPages;
	private long totalElements;
	private int currentPage;
}
