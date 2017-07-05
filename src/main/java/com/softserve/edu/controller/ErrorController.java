package com.softserve.edu.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController {
    @RequestMapping(value = "/403")
    public String accessDenied() {
        return "/error_pages/403_error";
    }
}
