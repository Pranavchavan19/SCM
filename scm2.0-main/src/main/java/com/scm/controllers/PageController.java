package com.scm.controllers;


import com.scm.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    

    @RequestMapping("/home")
    public String home(Model model) {

     System.out.println("home page h");

     model.addAttribute("name", "pranav chavan");
     model.addAttribute("chanel", "panu");
     model.addAttribute("github", "https://github.com/Pranavchavan19");

     return "home";
    }


    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("islogin", true);
       
     System.out.println("about page is loading");
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        System.out.println("This is services page");
        return "services";
    }

    @RequestMapping("/login")
    public String login(){ 
          return "login";
    }

    @RequestMapping("/register")
    public String register(){ 
        return "register";
    }
    
    @RequestMapping("/contact")
    public String contact(){ 
        return "contact";
    }
}
