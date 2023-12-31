package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @GetMapping("/hello")
    @ResponseBody
    public String returnHelloWorld(){
        return "Hello World";
    }
    @GetMapping("/another")
    @ResponseBody
    public String returnAnother(){
        return "Hello Again";
    }




}
