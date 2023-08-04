package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathContoller {

    @GetMapping("/add/{first_number}/and/{second_number}")
    @ResponseBody
    public int addition(@PathVariable int first_number,
                        @PathVariable int second_number) {
        return first_number + second_number;
    }
    @GetMapping("/subtract/{first_number}/from/{second_number}")
    @ResponseBody
    public int subtraction(@PathVariable int first_number,
                        @PathVariable int second_number) {
        return second_number - first_number;
    }
    @GetMapping("/multiply/{first_number}/and/{second_number}")
    @ResponseBody
    public int multiplication(@PathVariable int first_number,
                        @PathVariable int second_number) {
        return second_number * first_number;
    }
    @GetMapping("/divide/{first_number}/by/{second_number}")
    @ResponseBody
    public int division(@PathVariable int first_number,
                        @PathVariable int second_number) {
        return first_number / second_number;
    }

}
