package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Eq_id;

    private String Eq_name;

    private String Eq_birth;

    @Enumerated(value = EnumType.STRING) //
    private Session Eq_Session;

    @Builder
    private Equipment (String Eq_name, String Eq_birth, Session Eq_Session)
    {
        this.Eq_name = Eq_name;
        this.Eq_birth = Eq_birth;
        this.Eq_Session = Eq_Session;
    }
}
