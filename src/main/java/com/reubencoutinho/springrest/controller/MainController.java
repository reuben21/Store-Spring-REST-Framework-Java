package com.reubencoutinho.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/hello")
    public String get_HelloW_World_Message(){
        return "Hello World";
    }

    @GetMapping("/helloOne")
    public String get_HelloW_World_Message1(){
        return "Hello World Again";
    }
}
