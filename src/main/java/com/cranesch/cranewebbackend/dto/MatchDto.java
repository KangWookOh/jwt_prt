package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Match;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.Team_Role;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class MatchDto {
    private Long Match_id;

    private Team_Role Match_role;

    private User user_id;

    private Team team;

    public Match toEntity()
    {
        return Match.builder().
                role(Match_role).
                user_id(user_id).
                team(team).
                build();
    }
}
