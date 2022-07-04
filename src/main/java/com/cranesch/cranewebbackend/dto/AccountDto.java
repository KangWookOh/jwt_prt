package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Account;
import com.cranesch.cranewebbackend.entity.User;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AccountDto {
    private Long Id;

    private User user;

    private String Email;

    private String Password;

    private boolean Echeck;

    public Account toEntity(){
        return Account.builder()
                .user(user)
                .Email(Email)
                .Password(Password)
                .Echeck(Echeck)
                .build();
    }
}
