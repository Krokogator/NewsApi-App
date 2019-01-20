package com.krokogator.newsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class ApiRedirectController {

    @RequestMapping("/")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
