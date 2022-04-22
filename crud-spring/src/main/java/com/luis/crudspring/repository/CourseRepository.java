package com.luis.crudspring.repository;

import java.util.Optional;

import com.luis.crudspring.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    public Optional<Course> findById(Long id);

}
    

