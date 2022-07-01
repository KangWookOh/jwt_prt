package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.AccountDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.repository.AccountRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    @Transactional
    public Long SignUp(UserDto Udto, AccountDto Adto){
        Long user_id = userRepository.save(Udto.toEntity()).getUser_id();
        Adto.setUser(Udto.toEntity());
        return accountRepository.save(Adto.toEntity()).getID();
    }
}
