package com.samar.notesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class Check {
    @GetMapping("/test")
    public String healthCheck(){
        return "working";
    }
}
