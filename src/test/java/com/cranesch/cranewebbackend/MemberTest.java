package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void ReadMemberByTh(){
        int th = 20;
        List<User> userList = memberService.ReadUserByTh(th);

        System.out.printf( th + "기의 멤버입니다.\n");

        int i =1;
        for(User u : userList){
            System.out.printf( i++ + ": " + u.getUsername() + " //세션 : " + u.getSession() + "\n");
        }
    }


    @Test
    public void ReadMemberBySession()
    {
        List<User> sUserList = memberService.ReadUserBySession(Session.GUITAR);

        for(User u : sUserList)
        {
            System.out.printf("id : " + u.getId() + " / User : " + u.getUsername() + " / th : "
                    + u.getUserDept() + " / role : " + u.getUserRole()+ "\n");
        }
    }
}
