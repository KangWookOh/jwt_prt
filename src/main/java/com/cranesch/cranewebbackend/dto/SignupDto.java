package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
public class SignupDto {
    //accountDto

    private String userEmail;

    private String userPassword;


    //UserDto
    private String userName;

    private String userBirth;

    private String userStdId;

    private Session session;

    private String userDept;

    private UserRole userRole;

    private Integer userTh;

    private String userPhoneNum;

    @Builder
    public SignupDto(String email,String password,String userName,String userBirth,String userStdId,Session session,String userDept,UserRole userRole,
    Integer userTh,String userPhoneNum){
        this.userEmail=email;
        this.userPassword=password;
        this.userName=userName;
        this.userBirth=userBirth;
        this.userStdId=userStdId;
        this.session=session;
        this.userDept=userDept;
        this.userRole=userRole;
        this.userTh=userTh;
        this.userPhoneNum=userPhoneNum;
    }
//    @Builder
//    public SignupDto(String email,String password)
//    {
//        this.Email=email;
//        this.Password=password;
//    }
//    @Builder
//    public SignupDto(String userName,String userBirth,String userStdId,Session session,String userDept,UserRole userRole, Integer userTh,String userPhoneNum)
//    {
//        this.userName=userName;
//        this.userBirth=userBirth;
//        this.userStdId=userStdId;
//        this.session=session;
//        this.userDept=userDept;
//        this.userRole=userRole;
//        this.userTh=userTh;
//        this.userPhoneNum=userPhoneNum;
//
//    }
    public SignupDto() {

    }

}
