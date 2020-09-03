package com.wake.nlkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
// @RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() throws Exception{
        int a = 2;
        if(a == 2){
            throw new Exception("抛出异常");
        }
        return "HelloController中的hello方法";
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
