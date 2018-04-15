package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView mvc1(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("helloc");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}
