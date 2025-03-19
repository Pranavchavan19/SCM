package com.scm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scm.entities.user;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Aut
    private UserRepo userRepo;

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
        // TODO Auto-generated method stub
        return Optional.empty();
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<user> updateUser(user user) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }



}
