package com.universitycourse.universitycourse.repository;

import com.universitycourse.universitycourse.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {


}
