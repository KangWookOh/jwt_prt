package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.enums.Team_Role;
import com.cranesch.cranewebbackend.entity.enums.Team_Type;
import com.cranesch.cranewebbackend.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeamTest {
    @Autowired
    private TeamService teamService;

    @Test
    public void CreateTeam(){
        TeamDto teamDto = new TeamDto();
        teamDto.setTeam_name("테스트 팀");
        teamDto.setTeam_type(Team_Type.PERFORM);

        teamService.CreatTeam(teamDto);
    }

    @Test
    public void MatchTeam(){
        MatchDto matchDto = new MatchDto();
        matchDto.setMatch_role(Team_Role.Reader);

        teamService.AddTeamMember(matchDto, Long.valueOf(1), Long.valueOf(3));
    }

}
