package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.UserRole;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"Email","Password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private String Email;
    @JsonIgnore
    private String Password;

    @Column(nullable = false)
    private String userName;

    private String userBirth;

    private String userStdId;

    @Enumerated(value = EnumType.STRING) //
    private Session session;

    private String userDept;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    private int userTh;

    private String userPhoneNum;

    @Builder
    public User(String userName, String userBirth, String userStdId, Session session, String userDept,
                UserRole userRole, int userTh, String userPhoneNum,String email, String password)
    {
        this.Email=email;

        this.Password=password;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userStdId = userStdId;
        this.session = session;
        this.userDept =userDept;
        this.userRole = userRole;
        this.userTh = userTh;
        this.userPhoneNum = userPhoneNum;
    }

}
