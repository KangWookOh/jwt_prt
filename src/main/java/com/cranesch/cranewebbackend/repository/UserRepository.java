package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findBySession (Session session);
    List<User> findByUserTh(int th);
    List<User> findByUserName(String name);
    User findByUserEmail(String userEmail);

    }
