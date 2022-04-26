package com.luis.crudspring.controller;

import java.util.List;

import com.luis.crudspring.model.Course;
import com.luis.crudspring.repository.CourseRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor

public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Course> findById(@PathVariable long id) {
        return courseRepository.findById(id)
                .map(rec -> ResponseEntity.ok().body(rec))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable("id") Long id,
            @RequestBody Course course) {
        return courseRepository.findById(id)
                .map(rec -> {
                    rec.setName(course.getName());
                    rec.setStock(course.getStock());
                    rec.setTotalAmount(course.getTotalAmount());
                    rec.setUnitaryValue(course.getUnitaryValue());
                    Course updated = courseRepository.save(rec);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

}