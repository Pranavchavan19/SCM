package com.scm.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.user;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String  processRegister( @ModelAttribute UserForm userForm , HttpSession session){

        System.out.println("processing form");

        System.out.println(userForm);

        // user user1 =  user.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://avatars.githubusercontent.com/u/144905435?v=4")
        // .build();

        user user = new user();

        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://avatars.githubusercontent.com/u/144905435?v=4");


       user savedUser =  userService.saveUser(user);
       System.out.println("saved user");

      Message message = Message.builder().content("Registration Successfull").type(MessageType.blue).build();
       session.setAttribute("message" , message);
        return "redirect:/register";
    }
}
