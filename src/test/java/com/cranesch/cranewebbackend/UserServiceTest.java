package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.SignupDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.UserRole;
import com.cranesch.cranewebbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cranesch.cranewebbackend.repository.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;





    @Test
    public void test(){

        for(int i =1; i <= 30; i++) {

//            UserDto Udto = UserDto.builder()
//                    .userName("user" + i)
//                    .session(Session.GUITAR)
//                    .userBirth("000000")
//                    .userDept("User_dept")
//                    .userPhoneNum("000-0000-0000")
//                    .userRole(UserRole.ADMIN)
//                    .userStdId("00000000")
//                    .userTh(0)
//                    .build();
//
//            AccountDto Adto = AccountDto.builder()
//                    .email("######@###.com")
//                    .password("a;lsdkfjafl;k")
//                    .build();
           UserDto userDto = UserDto.builder()
                    .userName("username")
                    .userBirth("20000000")
                    .userDept("학과")
                    .userRole(UserRole.ADMIN)
                    .userStdId("20000000")
                    .userTh(40)
                    .userEmail("hyeseong@sch.ac.kr")
                    .userPhoneNum("01000000000")
                    .userPassword("pw")
                    .session(Session.BASS)
                    .build();
            userService.SignUp(userDto);
        }
    }

    /*@Test
    public void userupdatetest(){
        UserDto dto = UserDto.builder()
                .userName("송예림")
                .userPhoneNum("01011111111")
                .userRole(UserRole.USER)
                .build();
        userService.updateUser(dto,2L);
    }*/

    @Test
    public void DelUserTest()
    {
        Long userId = 10L;
        userService.DelUser(userId);
    }

}
