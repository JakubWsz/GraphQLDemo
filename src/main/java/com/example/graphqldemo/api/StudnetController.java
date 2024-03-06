package com.example.graphqldemo.api;

import com.example.graphqldemo.api.dto.StudentFilter;
import com.example.graphqldemo.api.dto.StudentPage;
import com.example.graphqldemo.entity.Student;
import com.example.graphqldemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StudnetController {
	private final StudentService studentService;

	@QueryMapping
	public StudentPage students(@Argument Integer page, @Argument Integer size, @Argument StudentFilter filter) {
		log.info("Fetching students with filters");
		Pageable pageable = PageRequest.of(page, size);
		Page<Student> studentPage = studentService.getStudents(pageable, filter);
		return new StudentPage(studentPage.getContent(), studentPage.getTotalPages(), studentPage.getTotalElements(), studentPage.getNumber());
	}
}
