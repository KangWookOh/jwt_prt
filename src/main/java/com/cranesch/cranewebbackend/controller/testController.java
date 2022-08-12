package com.cranesch.cranewebbackend.controller;


import com.cranesch.cranewebbackend.dto.SignupDto;
import com.cranesch.cranewebbackend.dto.UserDto;
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
    public ResponseEntity<Long> signUp(@RequestBody UserDto userDto)
    {
        Long userId = userService.SignUp(userDto);
        return ResponseEntity.ok().body(userId);

    }

    @GetMapping("/user")
    public ResponseEntity Userlist(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }


    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto,@PathVariable Long id)
    {
        User user = userService.updateUser(id, userDto);
        return ResponseEntity.ok().body(user);

    }






}
