package com.mitrais.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

    @RequestMapping("/article")
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

}
