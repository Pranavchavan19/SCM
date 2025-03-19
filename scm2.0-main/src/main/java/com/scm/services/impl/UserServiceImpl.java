package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        user user2 = userRepo.findById(id)
        .orElseThrow( () -> new ResourceNotFoundException("User Not Found Exception"));

         userRepo.delete(user2);

        
    }

    @Override
    public List<user> getAllUsers() {
        
        return userRepo.findAll();
    }

    @Override
    public Optional<user> getUserById(String id) {
       
        return userRepo.findById(id);
    }

    @Override
    public boolean isUserExist(String userId) {
       
        user user2 =  userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;

    }

    @Override
    public boolean isUserExistByEmail(String email) {
       
      user user2 = userRepo.findByEmail(email).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public user saveUser(user user) {
       
        // user Id : have to generate dynamically

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        // password encoded

        // user.setPassword(userId);
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
        user2.setProvider(user.getProvider());

        user2.setProviderUserId(user.getProviderUserId());

        // save user in database 

        user save =  userRepo.save(user2);

        return Optional.ofNullable(save);
    }



}
