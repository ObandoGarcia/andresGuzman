package com.obando.springcloud.msvc.cursos.services;

import com.obando.springcloud.msvc.cursos.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();

    Optional<Course> findById(Long id);

    Course save(Course course);

    void deleteById(Long id);
}
