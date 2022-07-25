package com.cranesch.cranewebbackend.dto;



import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
public class UserDto {

    private Long userId;

    private String userName;

    private String userBirth;

    private String userStdId;

    private Session session;

    private String userDept;

    private UserRole userRole;

    private Integer userTh;

    private String userPhoneNum;


//    public User toEntity() {
//        return User.builder()
//                .userName(userName)
//                .userBirth(userBirth)
//                .userStdId(userStdId)
//                .session(session)
//                .userDept(userDept)
//                .userRole(userRole)
//                .userTh(userTh)
//                .userPhoneNum(userPhoneNum)
//                .build();
//    }
    @Builder
    public UserDto(String userName, String userBirth,String userStdId,String userDept,Integer userTh,String userPhoneNum,Session session,UserRole userRole)
    {
        this.userName=userName;
        this.userBirth=userBirth;
        this.userStdId=userStdId;
        this.userDept=userDept;
        this.userTh=userTh;
        this.userPhoneNum=userPhoneNum;
        this.session = session;
        this.userRole = userRole;
    }


}
