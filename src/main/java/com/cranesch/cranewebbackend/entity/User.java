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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    private String userBirth;

    private String userStdId;

    @Enumerated(value = EnumType.STRING)
    private Session session;

    private String userDept;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    private int userTh;

    private String userPhoneNum;

    private String userEmail;

    private  String userPassword;

    private boolean eCheck;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnore
    private final List<String> roles = new ArrayList<>();

    //update method test
    public void usernameUpdate(String userDept,String userPhoneNum){
        this.userDept = userDept;
        this.userPhoneNum =userPhoneNum;
    }
    //userRole update impl

    @Builder
    public User(String userName, String userBirth, String userStdId, Session session, String userDept,
                UserRole userRole, int userTh, String userPhoneNum,String userEmail,String userPassword, boolean eCheck)
    {
        this.userName = userName;
        this.userBirth = userBirth;
        this.userStdId = userStdId;
        this.session = session;
        this.userDept =userDept;
        this.userRole = userRole;
        this.userTh = userTh;
        this.userPhoneNum = userPhoneNum;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.eCheck = eCheck;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
