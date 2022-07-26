package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.entity.Match;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.MatchRepository;
import com.cranesch.cranewebbackend.repository.TeamRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long CreatTeam(TeamDto teamDto){
       Team team= Team.builder()
               .teamName(teamDto.getTeamName())
               .teamType(teamDto.getTeamType())
               .isActive(teamDto.getIsActive())
               .build();
       return teamRepository.save(team).getId();
    }

    @Transactional
    public Long AddTeamMember(MatchDto matchDto,Long teamId, Long userId){
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if(optionalTeam.isEmpty()){
            throw new EntityExistsException("Team is not exist");
        }

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityExistsException("User is not exist");
        }

        Match match = Match.builder()
                .team(optionalTeam.get())
                .user(optionalUser.get())
                .teamRole(matchDto.getTeamRole())
                .build();
        return matchRepository.save(match).getId();
    }

    @Transactional(readOnly = true)
    public List<TeamDto> ReadTeam()
    {
        List<Team> teamList = teamRepository.findAll();

        List<TeamDto> teamDtoList = new ArrayList<>();

        for(Team t : teamList)
        {
            TeamDto dto = TeamDto.builder()
                    .teamName(t.getTeamName())
                    .teamType(t.getTeamType())
                    .isActive(t.getIsActive())
                    .build();

            teamDtoList.add(dto);
        }
        return teamDtoList;
    }

    @Transactional(readOnly = true)
    public List<MatchDto> ReadMemberByTeam(Long teamId)
    {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if(optionalTeam.isEmpty())
        {
            throw new EntityExistsException("Team Not Exist");
        }
        List<Match> matchList = matchRepository.findByTeamId(teamId);
        List<MatchDto> matchDtoList = new ArrayList<>();

        for(Match m : matchList)
        {
            MatchDto dto = MatchDto.builder()
                    .user(m.getUser())
                    .team(m.getTeam())
                    .teamRole(m.getMatchRole())
                    .build();

            matchDtoList.add(dto);
        }
        return matchDtoList;
    }

}
