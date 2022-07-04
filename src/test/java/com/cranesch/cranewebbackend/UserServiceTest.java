package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.AccountDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.Account;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.User_Role;
import com.cranesch.cranewebbackend.repository.UserRepository;
import com.cranesch.cranewebbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
        UserDto Udto = new UserDto();
        Udto.setUser_name("test_name");
        Udto.setUser_birth("220704");
        Udto.setUser_th(40);
        Udto.setUser_num("010-0000-0000");
        Udto.setUser_dept("User_dept");
        Udto.setUser_role(User_Role.ADMIN);
        Udto.setUser_stdId("20000000");
        Udto.setSession(Session.BASS);

        AccountDto Adto = new AccountDto();
        Adto.setEmail("########@####.com");
        Adto.setEcheck(true);
        Adto.setPassword("########");

        userService.SignUp(Udto,Adto);
    }





}
