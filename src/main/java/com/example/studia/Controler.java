package com.example.studia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controler {


    @PostMapping("/add")
    public String handleSubmit(@RequestParam String inputText) {
        return "add";
    }
}
