package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.Team_Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name="matchs")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Match_id;

    @Column(nullable = false)
    private Team_Role Match_role;

    @JoinColumn(name = "User_id")
    @ManyToOne
    private User User_id;

    @JoinColumn(name = "Team_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team team;

    @Builder
    private Match(Team_Role role)
    {
        this.Match_role = role;
    }
}
