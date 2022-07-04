package com.cranesch.cranewebbackend.dto;

import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.enums.Team_Type;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TeamDto {
    private Long Team_id;

    private Team_Type Team_type;

    private String Team_name;

    private Team toEntity()
    {
        return Team.builder().
                Team_type(Team_type).
                Team_name(Team_name).
                build();
    }
}
