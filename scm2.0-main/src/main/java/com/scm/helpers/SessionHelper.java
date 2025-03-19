package com.scm.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
    
    public static void removeMessage()
    {
       try {

        System.out.println("removing message in helper");
        
        HttpSession session =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        session.removeAttribute("message");
       } catch (Exception e) {
        System.out.println(" error  in session helper " + e);
        e.printStackTrace();
       }
    }


}
