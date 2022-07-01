package com.cranesch.cranewebbackend.controller;

import com.cranesch.cranewebbackend.dto.AccountDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@RestController
@RequestMapping("")
public class testController {

    private UserService userService;

//    @GetMapping("/main")
//    public ResponseEntity<Long> SaveUser(@RequestBody UserDto Udto,  AccountDto Adto)
//    {
//        return ResponseEntity.ok(UserService.SignUp(Udto, Adto));
//    }

}
