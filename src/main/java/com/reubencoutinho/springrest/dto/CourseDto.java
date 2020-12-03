package com.reubencoutinho.springrest.dto;

import com.reubencoutinho.springrest.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {

    List<Course> list = new ArrayList<>();
    private double discountPrice;

    public List<Course> getList() {
        return list;
    }

    public void setList(List<Course> list) {
        this.list = list;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
