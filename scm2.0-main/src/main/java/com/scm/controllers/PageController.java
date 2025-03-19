package com.scm.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;

@Controller
public class PageController {

    

    @GetMapping("/home")
    public String home(Model model) {

     System.out.println("home page h");

     model.addAttribute("name", "pranav chavan");
     model.addAttribute("chanel", "panu");
     model.addAttribute("github", "https://github.com/Pranavchavan19");

     return "home";
    }


    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("islogin", true);
       
     System.out.println("about page is loading");
        return "about";
    }

    @GetMapping("/services")
    public String services(){
        System.out.println("This is services page");
        return "services";
    }

    @GetMapping("/login")
    public String login(){ 
          return "login";
    }

    @GetMapping("/register")
    public String register( Model model){ 

        UserForm userForm = new UserForm();

        userForm.setName("pranav");
        // default data bhi dal sakte hei
        model.addAttribute("userForm", userForm);
        return "register";
    }
    
    @GetMapping("/contact")
    public String contact(){ 
        return "contact";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String  processRegister( @ModelAttribute UserForm userForm){

        System.out.println("processing form");

        System.out.println(userForm);
        return "redirect:/home";
    }
}
