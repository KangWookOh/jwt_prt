package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.TeamType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TeamType teamType;


    private String teamName;

    @Builder
    private Team(TeamType teamType, String teamName)
    {
        this.teamType = teamType;
        this.teamName = teamName;
    }

}
