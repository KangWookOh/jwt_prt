package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
import com.cranesch.cranewebbackend.dto.UserDto;
import com.cranesch.cranewebbackend.entity.Team;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.repository.MatchRepository;
import com.cranesch.cranewebbackend.repository.TeamRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CreatTeam(TeamDto teamDto){
        return teamRepository.save(teamDto.toEntity()).getTeam_id();
    }

    @Transactional
    public Long AddTeamMember(MatchDto matchDto,Long team_id, Long user_id){
        Optional<Team> optionalTeam = teamRepository.findById(team_id);
        if(!optionalTeam.isPresent()){
            throw new EntityExistsException("Team is not exist");
        }

        Optional<User> optionalUser = userRepository.findById(user_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User is not exist");
        }

        matchDto.setTeam(optionalTeam.get());
        matchDto.setUser_id(optionalUser.get());
        return matchRepository.save(matchDto.toEntity()).getMatch_id();
    }


}
