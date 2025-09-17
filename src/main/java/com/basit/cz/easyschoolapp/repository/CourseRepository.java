package com.basit.cz.easyschoolapp.repository;

import com.basit.cz.easyschoolapp.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {
}
