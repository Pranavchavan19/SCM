package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.user;

public interface UserService {

    user  saveUser(user user);
    
    Optional<user> getUserById(String  id);

    Optional<user> updateUser(user user);

    void deleteUser(String id);

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);

    List<user> getAllUsers();

}
