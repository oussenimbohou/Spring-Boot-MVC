package com.barack.springbootdemo.controller;

import com.barack.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello World, I'm so happy to learn devTools dependency...";
    }

    @GetMapping("/user")
    public User user(){
        return new User("1", "Hussein", "barack@gmail.com");

    }
    @GetMapping("/{id1}/{id2}")
    public String pathVariable(@PathVariable String id1, @PathVariable("id2") String name){
        return "The path variable id1 is: "+ id1 + " and the name is: "+ name;
    }
    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name, @RequestParam(required = false, defaultValue = "") String emailId){
        return "The name is : "+name +" and the emailId is "+emailId;
    }
}
