package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.SignupDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.Account;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.AccountRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.UserDatabase;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public Long SignUp(SignupDto signupDto)
    {
        User user = User.builder()
                .userName(signupDto.getUserName())
                .userBirth(signupDto.getUserBirth())
                .userStdId(signupDto.getUserStdId())
                .session(signupDto.getSession())
                .userDept(signupDto.getUserDept())
                .userRole(signupDto.getUserRole())
                .userTh(signupDto.getUserTh())
                .userPhoneNum(signupDto.getUserPhoneNum())
                .build();

        Account account = Account.builder()
                .Email(signupDto.getUserEmail())
                .Password(signupDto.getUserPassword())
                .user(user)
                .build();
        return accountRepository.save(account).getId();
    }

    public List<UserDto> getAllUser()
    {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User u : userList){
            UserDto userDto = UserDto.builder()
                    .userName(u.getUserName())
                    .userTh(u.getUserTh())
                    .userStdId(u.getUserStdId())
                    .userRole(u.getUserRole())
                    .userPhoneNum(u.getUserPhoneNum())
                    .userDept(u.getUserDept())
                    .userBirth(u.getUserBirth())
                    .session(u.getSession())
                    .userBirth(u.getUserBirth())
                    .build();
            userDtoList.add(userDto);
        }
        return userDtoList;

    }



//    @Transactional
//    public Long SignUp(UserDto Udto, AccountDto Adto){
//        Adto.setUser(Udto.toEntity());
//        return accountRepository.save(Adto.toEntity()).getId();
//    }

}
