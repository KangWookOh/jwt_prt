package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.MemberRemoval;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MemberService {

    private UserRepository userRepository;


    @Transactional
    public List<User> ReadUserBySession(Session session){
        List<User> UserList = userRepository.findBySession(session);
        if(UserList.isEmpty())
        {
            log.info("User not exist.");
        }
        return UserList;
    }

    @Transactional
    public List<User> ReadUserByTh(int th){
        List<User> userList = userRepository.findByUserTh(th);
        if(userList.isEmpty()){
            throw new EntityExistsException("no user");
        }
        return userList;
    }
}
