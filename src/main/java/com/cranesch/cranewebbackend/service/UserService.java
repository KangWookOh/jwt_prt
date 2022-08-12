package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.SignupDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.UserDatabase;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long SignUp(UserDto userDto) {
        User user = User.builder()
                .userName(userDto.getUserName())
                .userBirth(userDto.getUserBirth())
                .userStdId(userDto.getUserStdId())
                .session(userDto.getSession())
                .userDept(userDto.getUserDept())
                .userRole(userDto.getUserRole())
                .userTh(userDto.getUserTh())
                .userPhoneNum(userDto.getUserPhoneNum())
                .userEmail(userDto.getUserEmail())
                .userPassword(userDto.getUserPassword())
                .build();

        return userRepository.save(user).getId();
    }

    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User u : userList) {
            UserDto userDto = UserDto.builder()
                    .userName(u.getUsername())
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

    @Transactional
    public User updateUser(Long id ,UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException(" "));
        user.usernameUpdate(userDto.getUserDept(), userDto.getUserPhoneNum());
        return userRepository.save(user);
    }


    @Transactional
    public void DelUser(Long userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty())
        {
            throw new EntityExistsException("User Not Exist");
        }

        userRepository.deleteById(userId);
    }
}


//    @Transactional
//    public Long SignUp(UserDto Udto, AccountDto Adto){
//        Adto.setUser(Udto.toEntity());
//        return accountRepository.save(Adto.toEntity()).getId();
//    }


