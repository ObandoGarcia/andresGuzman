package com.obando.springcloud.msvc.cursos.repositories;

import com.obando.springcloud.msvc.cursos.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
