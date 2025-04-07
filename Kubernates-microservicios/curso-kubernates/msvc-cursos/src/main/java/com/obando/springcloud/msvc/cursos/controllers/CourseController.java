package com.obando.springcloud.msvc.cursos.controllers;

import com.obando.springcloud.msvc.cursos.models.Course;
import com.obando.springcloud.msvc.cursos.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> listCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> courseDetails(@PathVariable Long id){
        Optional<Course> courseOptional = courseService.findById(id);

        return courseOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course courseDb = courseService.save(course);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> editCourse(@RequestBody Course course, @PathVariable Long id){
        Optional<Course> optionalCourse = courseService.findById(id);

        if (optionalCourse.isPresent()){
            Course courseDb = optionalCourse.get();
            courseDb.setName(course.getName());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(courseService.save(courseDb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourseById(@PathVariable Long id){
        Optional<Course> optionalCourse = courseService.findById(id);

        if (optionalCourse.isPresent()){
            courseService.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}