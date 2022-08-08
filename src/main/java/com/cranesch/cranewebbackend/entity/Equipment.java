package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Session;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eqName;

    private String eqBirth;

    @Enumerated(value = EnumType.STRING)
    private Session eqSession;


    public void equipmentUpdate(String eqName, String eqBirth)
    {
        this.eqName = eqName;
        this.eqBirth = eqBirth;
    }

    @Builder
    private Equipment (String eqName, String eqBirth, Session eqSession)
    {
        this.eqName = eqName;
        this.eqBirth = eqBirth;
        this.eqSession = eqSession;
    }
}
