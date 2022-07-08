package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private String userName;

    private String userBirth;

    private String userStdId;

    private Session session;

    private String userDept;

    private UserRole userRole;

    private int userTh;

    private String userPhoneNum;

    public User toEntity(){
        return User.builder()
                .userName(userName)
                .userBirth(userBirth)
                .userStdId(userStdId)
                .session(session)
                .userDept(userDept)
                .userRole(userRole)
                .userTh(userTh)
                .userPhoneNum(userPhoneNum)
                .build();
    }
}
