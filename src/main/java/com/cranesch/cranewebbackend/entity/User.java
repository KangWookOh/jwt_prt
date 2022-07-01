package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.User_Role;
import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_id;

    @Column(nullable = false)
    private String User_name;

    private String User_Birth;

    private String User_StdId;

    @Enumerated(value = EnumType.STRING) //
    private Session Session;

    private String User_Dept;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private User_Role User_Role;

    private int User_Th;

    private String User_Num;

    @Builder
    public User(String User_name, String User_Birth, String User_StdId, Session Session, String User_Dept,
                User_Role User_role, int User_Th, String User_Num)
    {
        this.User_name = User_name;
        this.User_Birth = User_Birth;
        this.User_StdId = User_StdId;
        this.Session = Session;
        this.User_Dept =User_Dept;
        this.User_Role = User_role;
        this.User_Th = User_Th;
        this.User_Num = User_Num;
    }

}
