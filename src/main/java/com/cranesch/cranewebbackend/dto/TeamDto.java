package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.enums.TeamType;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TeamDto {
    private TeamType teamType;

    private String teamName;

    public Team toEntity()
    {
        return Team.builder().
                teamType(teamType).
                teamName(teamName).
                build();
    }
}
