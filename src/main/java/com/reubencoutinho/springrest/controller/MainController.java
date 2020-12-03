package com.reubencoutinho.springrest.controller;

import com.reubencoutinho.springrest.dto.CourseDto;
import com.reubencoutinho.springrest.model.Course;
import com.reubencoutinho.springrest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/hello")
    public String get_HelloW_World_Message() {
        return "Hello World";
    }


    @PostMapping("/api/course")
    public Course postCourse(@RequestBody Course course) {
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    @GetMapping("/api/course")
    public CourseDto getCourse() {
        CourseDto dto = new CourseDto();
        double total = 0;
        List<Course> list = courseRepository.findAll();
        for (Course c : list) {
            total = total + c.getPrice();
        }
        total = total - (total * 0.1); //10% Discount
        dto.setDiscountPrice(total);
        dto.setList(list);
        return dto;
    }


}
