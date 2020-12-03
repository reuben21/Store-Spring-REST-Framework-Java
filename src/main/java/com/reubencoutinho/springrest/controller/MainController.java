package com.reubencoutinho.springrest.controller;

import com.reubencoutinho.springrest.dto.CourseDto;
import com.reubencoutinho.springrest.model.Course;
import com.reubencoutinho.springrest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/api/course/pagination") //localhost:8080/api/course/pagination?page=2&size=2
    public CourseDto getCoursePages(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                    @RequestParam(value = "size", required = false, defaultValue = "4") int size,
                                    @RequestParam(value = "sort", required = false, defaultValue = "ASC") String direction,
                                    @RequestParam(value = "sortParam", required = false, defaultValue = "price") String sortParam) {
        CourseDto dto = new CourseDto();
        double total = 0;
        //Sorting By Descending or Ascending
        //localhost:8080/api/course/pagination?page=0&size=2&sort=DESC

        //Sorting By Name
        //localhost:8080/api/course/pagination?sortParam=name
        Sort sort;
        if (direction.equals("ASC")) {
            sort = Sort.by(Sort.Direction.ASC, sortParam);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortParam);
        }
        Pageable pageable = PageRequest.of(page, size, sort);

        List<Course> list = courseRepository.findAll(pageable).getContent();
        for (Course c : list) {
            total = total + c.getPrice();
        }
        total = total - (total * 0.2); //10% Discount
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
