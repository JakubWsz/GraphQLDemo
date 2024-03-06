package com.example.graphqldemo.service;

import com.example.graphqldemo.StudentSpecifications;
import com.example.graphqldemo.api.dto.StudentFilter;
import com.example.graphqldemo.entity.Student;
import com.example.graphqldemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;

	public Page<Student> getStudents(Pageable pageable, StudentFilter filter) {
		Specification<Student> spec = StudentSpecifications.withFilter(filter);
		return studentRepository.findAll(spec, pageable);
	}
}
