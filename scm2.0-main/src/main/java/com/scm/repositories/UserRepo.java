package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.user;

@Repository
public interface UserRepo extends JpaRepository<user, String>{

}
