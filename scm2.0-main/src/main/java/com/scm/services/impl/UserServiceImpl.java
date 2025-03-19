package com.scm.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.user;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;


    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<user> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<user> getUserById(String id) {
       
        return userRepo.findById(id);
    }

    @Override
    public boolean isUserExist(String userId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public user saveUser(user user) {
       
        return userRepo.save(user);
    }

    @Override
    public Optional<user> updateUser(user user) {
      
        user user2 = userRepo.findById(user.getUserId()).orElseThrow( () -> new ResourceNotFoundException("User Not Found Exception"));
       
        // update karenge user2 se  user 

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());

        user2.setPhoneVerified(user.isPhoneVerified());
    }



}
