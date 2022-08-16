package com.junhopark.testProject.testProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    // attribute를 활용한 templates
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // 변수 적용
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, String test, Model model){
        model.addAttribute("name", name);
        model.addAttribute("test", test);
        return "helloMvc";
    }

    // 파라미터 바로 넘겨주기
    @GetMapping("hello-string")
    @ResponseBody
    public String hello(@RequestParam("name") String name,Model model){
        return "hello" + name;
    }

    //json으로 전달 (httpMessageConverter -> jackson2)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }
}
