package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.User_Role;
import lombok.Data;

@Data
public class UserDto {

    private String User_name;

    private String User_birth;

    private String User_stdId;

    private Session session;

    private String User_dept;

    private User_Role User_role;

    private int User_th;

    private String User_num;

    public User toEntity(){
        return User.builder()
                .User_name(User_name)
                .User_Birth(User_birth)
                .User_StdId(User_stdId)
                .Session(session)
                .User_Dept(User_dept)
                .User_role(User_role)
                .User_Th(User_th)
                .User_Num(User_num)
                .build();
    }
}
