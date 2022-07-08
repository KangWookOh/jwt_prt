package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.AccountDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.UserRole;
import com.cranesch.cranewebbackend.repository.UserRepository;
import com.cranesch.cranewebbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        for(int i =0; i < 30; i++) {
            UserDto Udto = new UserDto();
            Udto.setUserName("test_name");
            Udto.setUserBirth("220704");
            Udto.setUserTh(i);
            Udto.setUserPhoneNum("010-0000-0000");
            Udto.setUserDept("User_dept");
            Udto.setUserRole(UserRole.ADMIN);
            Udto.setUserStdId("20000000");
            Udto.setSession(Session.BASS);

            AccountDto Adto = new AccountDto();
            Adto.setEmail("########@####.com");
            Adto.setEcheck(true);
            Adto.setPassword("########");

            userService.SignUp(Udto, Adto);
        }
    }





}
