package com.hello.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

//    @RequestMapping("/welcome.html")
//    public ModelAndView firstPage() {
//        return new ModelAndView("welcome");
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/helloworld")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }
}
