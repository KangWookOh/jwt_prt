package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.ReplyDto;
import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Reply;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import com.cranesch.cranewebbackend.repository.BoardRepository;
import com.cranesch.cranewebbackend.repository.ReplyRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BoardService {
    private BoardRepository boardRepository;
    private ReplyRepository replyRepository;
    private UserRepository userRepository;

    @Transactional
    public Long CreateBoard(BoardDto dto, Long User_id)
    {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User not exist.");
        }
        dto.setUser(optionalUser.get());
        dto.setBoardView(Long.valueOf(0));

    return boardRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long CreateReply(ReplyDto replyDto, Long userId, Long boardId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User is not exist");
        }

        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(!optionalBoard.isPresent()){
            throw new EntityExistsException("Board is not exist");
        }

        replyDto.setBoard(optionalBoard.get());
        replyDto.setUser(optionalUser.get());
        return replyRepository.save(replyDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<Board> ReadBoardByType(BoardType boardType){
        List<Board> boardList = boardRepository.findByBoardType(boardType);
        if(boardList.isEmpty()){
            throw new EntityExistsException("Board type " + boardType + " is not exist");
        }
        return boardList;
    }

    //Entity를 return 해도 괜찮은 걸까요?
    @Transactional(readOnly = true)
    public Board ReadBoardById(Long boardId){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isEmpty()){
            throw new EntityExistsException("Board is not exist");
        }

        return optionalBoard.get();
    }

    @Transactional(readOnly = true)
    public List<Reply> ReadReplyByBoardId(Long boardId){
        List<Reply> replyList = replyRepository.findByBoardId(boardId);
        if(replyList.isEmpty()){
            throw new EntityExistsException("Board id " + boardId + " has no reply");
        }

        return replyList;
    }



    @Transactional(readOnly = true)
    public List<Board> ReadBoardByUser(Long userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            new EntityExistsException("User not Exist");
        }
        List<Board> uBoardList = boardRepository.findByUserId(userId);

        return uBoardList;
    }
}
