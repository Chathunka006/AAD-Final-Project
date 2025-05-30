package com.example.studywithchathu.Repo;

import com.example.studywithchathu.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {

    User findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail(String userName);

    boolean existsByPassword(String password);



}