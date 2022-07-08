package com.cranesch.cranewebbackend.entity;

import com.cranesch.cranewebbackend.entity.enums.TeamRole;
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
    private Long matchId;

    @Column(nullable = false)
    private TeamRole matchRole;

    @JoinColumn
    @ManyToOne
    private User user;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Team team;

    @Builder
    private Match(TeamRole teamRole, User user, Team team)
    {
        this.matchRole = teamRole;
        this.user = user;
        this.team = team;
    }
}
