package com.example.graphqldemo.utils;

import com.example.graphqldemo.entity.Student;
import com.example.graphqldemo.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataSupplier {

	private final StudentRepository studentRepository;
	private final Faker faker = new Faker();
	Random random = new Random();

	@PostConstruct
	public void supply() {
		createStudents();
	}

	private void createStudents() {
		for (int i = 0; i < 100; i++) {

			studentRepository.save(new Student(
					faker.name().firstName(),
					faker.name().lastName(),
					UUID.randomUUID().toString(),
					random.nextInt(60 - 19) + 19));
		}
	}
}
