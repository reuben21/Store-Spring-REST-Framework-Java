package com.reubencoutinho.springrest.controller;

import com.reubencoutinho.springrest.dto.CourseDto;
import com.reubencoutinho.springrest.model.Course;
import com.reubencoutinho.springrest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/course/pagination")
    public CourseDto getCoursePages(@RequestParam("page") int page,@RequestParam("size") int size) {
        CourseDto dto = new CourseDto();
        double total = 0;
        Pageable pageable = PageRequest.of(page,size);

        List<Course> list = courseRepository.findAll(pageable).getContent();
        for (Course c : list) {
            total = total + c.getPrice();
        }
        total = total - (total * 0.1); //10% Discount
        dto.setDiscountPrice(total);
        dto.setList(list);
        return dto;
    }

    @DeleteMapping("/api/course/{id}")
    public String deleteCourse(@PathVariable("id") long id) {
        courseRepository.deleteById(id);
        return "Course with ID " + id + " Deleted";

    }

    @PutMapping("/api/course/{id}")
    public Course editCourse(@RequestBody Course courseUpdated, @PathVariable("id") long id) {
        Course courseDB = courseRepository.getOne(id);
        courseDB.setName(courseUpdated.getName());
        courseDB.setShortDescription(courseUpdated.getShortDescription());
        courseDB.setDescription(courseUpdated.getDescription());
        //NOT ALLOWING PRICE UPDATION
        return courseRepository.save(courseDB);
    }

}
