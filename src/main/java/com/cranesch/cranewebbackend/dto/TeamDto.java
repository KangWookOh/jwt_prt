package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.enums.TeamType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TeamDto {
    private TeamType teamType;
    private String teamName;
    private Boolean isActive;

//    public Team toEntity()
//    {
//        return Team.builder().
//                teamType(teamType).
//                teamName(teamName).
//                build();
//    }
    @Builder
    public TeamDto(TeamType teamType, String teamName, Boolean isActive)
    {
        this.teamType = teamType;
        this.teamName = teamName;
        this.isActive = isActive;
    }
}
