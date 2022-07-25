package com.cranesch.cranewebbackend.controller;


import com.cranesch.cranewebbackend.dto.SignupDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.Account;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.service.UserService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@JsonAutoDetect
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class testController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<Long> SaveUser(@RequestBody SignupDto signupDto)
    {
        return ResponseEntity.ok(userService.SignUp(signupDto));
    }

    @GetMapping("/user")
    private ResponseEntity Userlist(){
        return ResponseEntity.ok(userService.getAllUser());

    }






}
