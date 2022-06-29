package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Team_Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Team_id;

    private Team_Type Team_type;

    private String Team_name;

    @Builder
    private Team(Team_Type Team_type, String Team_name)
    {
        this.Team_type = Team_type;
        this.Team_name = Team_name;
    }

}
