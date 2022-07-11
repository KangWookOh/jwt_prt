package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.MatchDto;
import com.cranesch.cranewebbackend.dto.TeamDto;
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
        return teamRepository.save(teamDto.toEntity()).getId();
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

        matchDto.setTeam(optionalTeam.get());
        matchDto.setUser(optionalUser.get());
        return matchRepository.save(matchDto.toEntity()).getId();
    }


}
