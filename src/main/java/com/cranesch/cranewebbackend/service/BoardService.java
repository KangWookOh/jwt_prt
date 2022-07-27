package com.cranesch.cranewebbackend.service;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.ReplyDto;
import com.cranesch.cranewebbackend.entity.Board;
import com.cranesch.cranewebbackend.entity.Reply;
import com.cranesch.cranewebbackend.entity.User;
import com.cranesch.cranewebbackend.entity.Video;
import com.cranesch.cranewebbackend.entity.enums.BoardState;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import com.cranesch.cranewebbackend.repository.BoardRepository;
import com.cranesch.cranewebbackend.repository.ReplyRepository;
import com.cranesch.cranewebbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long CreateBoard(BoardDto dto, Long User_id)
    {
        Optional<User> optionalUser = userRepository.findById(User_id);
        if(!optionalUser.isPresent()){
            throw new EntityExistsException("User not exist.");
        }
        Board board = Board.builder()
                .boardTitle(dto.getBoardTitle())
                .boardContents(dto.getBoardContents())
                .boardType(dto.getBoardType())
                .boardView(0)
                .boardState(BoardState.BASIC) //
                .user(optionalUser.get())
                .build();

        return boardRepository.save(board).getId();
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

        Reply reply = Reply.builder()
                .replyComment(replyDto.getReplyComment())
                .user(optionalUser.get())
                .board(optionalBoard.get())
                .build();

        return replyRepository.save(reply).getId();
    }

    @Transactional
    public int increaseBoardView(Long id){
        return boardRepository.updateView(id);
    }

    @Transactional(readOnly = true)
    public List<BoardDto> ReadBoardByType(BoardType boardType){
        List<Board> boardList = boardRepository.findByBoardType(boardType);
        List<BoardDto> boardDtoList = new ArrayList<>();
        if(boardList.isEmpty()){
            log.info("NoBoard");
        }

        for(Board b : boardList) {
            if (b.getBoardState() == BoardState.BASIC) { // 이렇게 하는게 맞을가요
                BoardDto dto = BoardDto.builder()
                        .boardTitle(b.getBoardTitle())
                        .boardContents(b.getBoardContents())
                        .boardType(b.getBoardType())
                        .user(b.getUser())
                        .boardView(b.getBoardView())
                        .build();

                boardDtoList.add(dto);
            }
        }
        return boardDtoList;
    }

    @Transactional(readOnly = true)
    public BoardDto ReadBoardById(Long boardId){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isEmpty()){
            throw new EntityExistsException("Board is not exist");
        }

        Board board = optionalBoard.get();

        BoardDto dto = BoardDto.builder()
                .boardTitle(board.getBoardTitle())
                .boardContents(board.getBoardContents())
                .boardType(board.getBoardType())
                .boardView(board.getBoardView())
                .user(board.getUser())
                .build();

        return dto;
    }

    @Transactional(readOnly = true)
    public List<ReplyDto> ReadReplyByBoardId(Long boardId){
        List<Reply> replyList = replyRepository.findByBoardId(boardId);
        List<ReplyDto> replyDtoList = new ArrayList<>();
        if(replyList.isEmpty()){
            throw new EntityExistsException("Board id " + boardId + " has no reply");
        }

        for(Reply r : replyList){
            ReplyDto dto = ReplyDto.builder()
                    .replyComment(r.getReplyComment())
                    .user(r.getUser())
                    .board(r.getBoard())
                    .build();

            replyDtoList.add(dto);
        }

        return replyDtoList;
    }



    @Transactional(readOnly = true)
    public List<BoardDto> ReadBoardByUser(Long userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityExistsException("User not Exist");
        }
        List<Board> uBoardList = boardRepository.findByUserId(userId);
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board b : uBoardList){
            BoardDto dto = BoardDto.builder()
                    .boardTitle(b.getBoardTitle())
                    .boardContents(b.getBoardContents())
                    .boardType(b.getBoardType())
                    .user(b.getUser())
                    .boardView(b.getBoardView())
                    .build();

            boardDtoList.add(dto);
        }

        return boardDtoList;
    }
//    @Transactional
//    public Long updateView(long id)
//    {
//        return boardRepository.UpdateView(id);
//    }


    @Transactional
    public void DeleteReply(Long replyId){
        Optional<Reply> optionalReply = replyRepository.findById(replyId);
        if(optionalReply.isEmpty()){
            log.error("Reply is not exist");
            throw new EntityExistsException("NoReply");
        }

        replyRepository.delete(optionalReply.get());
    }

    @Transactional
    public void DeleteBoard(Long boardId){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        List<Reply> replyList = replyRepository.findByBoardId(boardId);
        if(optionalBoard.isEmpty()){
            log.error("Board is not exist");
            throw new EntityExistsException("NoBoard");
        }
        for(Reply r : replyList){
            replyRepository.delete(r);
        }
        boardRepository.delete(optionalBoard.get());
    }

}
