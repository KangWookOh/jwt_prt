package com.cranesch.cranewebbackend.repository;

import com.cranesch.cranewebbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
