package com.includo.service;

import com.includo.model.Course;
import com.includo.repository.CourseRepository;

public class CourseService {

    private CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public void showAllCourses() {

        for (Course course : repository.getCourses()) {

            System.out.println(course);

        }
    }
}