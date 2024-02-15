package com.example.studia.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddPlanController {
    @GetMapping("/addPlan")
    public String customLogin() {
        return "addPlan";
    }
}
