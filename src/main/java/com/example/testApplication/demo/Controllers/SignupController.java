package com.example.testApplication.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {


    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }
}
