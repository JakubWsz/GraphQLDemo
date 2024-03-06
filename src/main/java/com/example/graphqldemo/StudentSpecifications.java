package com.example.graphqldemo;

import com.example.graphqldemo.api.dto.StudentFilter;
import com.example.graphqldemo.entity.Student;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StudentSpecifications {

	public static Specification<Student> withFilter(StudentFilter filter) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (filter.getNameIn() != null && !filter.getNameIn().isEmpty()) {
				predicates.add(root.get("firstName").in(filter.getNameIn()));
			}

			if (filter.getNameContains() != null && !filter.getNameContains().isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("firstName")), "%" + filter.getNameContains().toLowerCase() + "%"));
			}

			if (filter.getAgeGreater() != null) {
				predicates.add(cb.greaterThan(root.get("age"), filter.getAgeGreater()));
			}
			if (filter.getAgeLess() != null) {
				predicates.add(cb.lessThan(root.get("age"), filter.getAgeLess()));
			}
			if (filter.getAgeEquals() != null) {
				predicates.add(cb.equal(root.get("age"), filter.getAgeEquals()));
			}
			if (filter.getMinAge() != null && filter.getMaxAge() != null) {
				predicates.add(cb.between(root.get("age"), filter.getMinAge(), filter.getMaxAge()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}