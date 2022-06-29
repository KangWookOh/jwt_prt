package com.cranesch.cranewebbackend.entity;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @JoinColumn(name ="User_Id")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)

    private String Password;

    @Column(nullable = false)
    private boolean Echeck;

    @Builder
    private Account(User user, String Email, String Password, boolean Echeck)
    {
        this.user =user;
        this.Email = Email;
        this.Password = Password;
        this. Echeck = Echeck;
    }

}
