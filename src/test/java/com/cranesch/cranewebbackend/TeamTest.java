package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.Match;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.TeamRole;
import com.cranesch.cranewebbackend.entity.enums.TeamType;
import com.cranesch.cranewebbackend.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeamTest {
    @Autowired
    private TeamService teamService;
    //team type String check!
    @Test
    public void CreateTeam(){
        TeamDto teamDto = TeamDto.builder()
                .teamName("축제 합주팀")
                .isActive(true)
                .build();
        teamDto.setTeamType(TeamType.PERFORM);

        teamService.CreatTeam(teamDto);
    }

    @Test
    public void MatchTeam(){
        MatchDto matchDto = MatchDto.builder()
                .teamRole(TeamRole.LEADER)
                .build();

        teamService.AddTeamMember(matchDto, 2L, 4L);
    }

    @Test
    public void ReadTeam() {
        List<TeamDto> teamDtoList = teamService.ReadTeam();
        for (TeamDto t : teamDtoList)
        {
            System.out.println("Team name : "+ t.getTeamName() + " / Team Type : "+ t.getTeamType());
        }
    }

    @Test
    public void ReadMemberByTeam()
    {
        Long teamId = 1L;
        List<MatchDto> matchDtoList = teamService.ReadMemberByTeam(teamId);

        for(MatchDto m: matchDtoList)
        {
            System.out.println("Session  : "+ m.getTeamRole() +" / Name : "+ m.getUser().getUserName());
        }
    }
    // 됐었는데 안될지도 모름

    @Test
    public void DelMatch()
    {
        Long matchId = 3L;
        teamService.DeleteTeamMatch(matchId);
    }

    @Test
    public void DelTeam()
    {
        Long teamId = 2L;
        teamService.DeleteTeam(teamId);
    }
}
