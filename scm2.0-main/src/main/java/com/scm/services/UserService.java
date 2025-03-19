package com.scm.services;

import com.scm.entities.user;

public interface UserService {

    user  saveUser(user user);
    
    user getUserById(String  id);

    user updateUser(user user);

    void deleteUser(String id);

    boolean isUserExist(String userId);

    boolean isUserExistByUsername(String email);

}
