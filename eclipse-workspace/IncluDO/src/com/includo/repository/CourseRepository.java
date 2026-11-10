package com.includo.repository;

import java.util.ArrayList;

import com.includo.model.Course;

public class CourseRepository {

    private ArrayList<Course> courses;

    public CourseRepository() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course findById(int id) {

        for (Course course : courses) {

            if (course.getId() == id) {
                return course;
            }

        }

        return null;
    }
}
