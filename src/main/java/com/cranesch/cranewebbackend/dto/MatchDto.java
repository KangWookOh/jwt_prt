package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Match;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Session;
import com.cranesch.cranewebbackend.entity.enums.TeamRole;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class MatchDto {
    private TeamRole teamRole;

    private User user;

    private Team team;

    private Session session;

//    public Match toEntity()
//    {
//        return Match.builder().
//                teamRole(teamRole).
//                user(user).
//                team(team).
//                build();
//    }

    @Builder
    public MatchDto(User user,Team team,TeamRole teamRole, Session session)
    {
        this.user=user;
        this.team=team;
        this.teamRole=teamRole;
        this.session = session;
    }
}
