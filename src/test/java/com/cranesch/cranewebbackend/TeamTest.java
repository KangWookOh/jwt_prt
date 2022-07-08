package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.enums.TeamRole;
import com.cranesch.cranewebbackend.entity.enums.TeamType;
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
        teamDto.setTeamName("테스트 팀");
        teamDto.setTeamType(TeamType.PERFORM);

        teamService.CreatTeam(teamDto);
    }

    @Test
    public void MatchTeam(){
        MatchDto matchDto = new MatchDto();
        matchDto.setTeamRole(TeamRole.Reader);

        teamService.AddTeamMember(matchDto, Long.valueOf(1), Long.valueOf(3));
    }

}
