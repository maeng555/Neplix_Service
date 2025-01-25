package com.example.fcss_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWord {
    @GetMapping("/api/v1/hello")
    public String hello(){
        return "hello security word";
    } //의존성을추가햇으면 따로설정없으면 - > user:UUi값 localhost:8080/api/v1/hello
}
