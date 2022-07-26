package com.cranesch.cranewebbackend;

import com.cranesch.cranewebbackend.dto.BoardDto;
import com.cranesch.cranewebbackend.dto.ReplyDto;
import com.cranesch.cranewebbackend.entity.enums.BoardType;
import com.cranesch.cranewebbackend.repository.UserRepository;
import com.cranesch.cranewebbackend.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTest {
    
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void BoardCreateTest()
    {

        for(int i =1; i <= 10; i++) {
            BoardDto bdto = BoardDto.builder()
                    .boardTitle("BoardTest" + i)
                    .boardContents("testcontents" + i)
                    .boardType(BoardType.ADMIN)
                    .build();

            boardService.CreateBoard(bdto, 3L);
        }
    }
    
    @Test
    public void ReplyCreateTest(){
        ReplyDto replyDto = ReplyDto.builder()
                .replyComment("댓글 테스트")
                .build();
        
        boardService.CreateReply(replyDto,2L, 1L);
    }

    @Test
    public void ReadBoardByType(){
        List<BoardDto> boardList = boardService.ReadBoardByType(BoardType.ADMIN);
        int i = 1;
        for(BoardDto b : boardList){
            System.out.printf(i++ + "번째 보드입니다 " + "// type: " + b.getBoardType() + " // title: " + b.getBoardTitle() + "\n");
        }
    }

    @Test
    public void ReadBoardAndReplyByBoardId(){
        Long boardId = Long.valueOf(1);
        BoardDto boardDto = boardService.ReadBoardById(Long.valueOf(1));
        List<ReplyDto> replyDtoList = boardService.ReadReplyByBoardId(Long.valueOf(1));

        System.out.printf("제목: " + boardDto.getBoardTitle() + " 타입 : " + boardDto.getBoardType() + "\n");
        System.out.printf("내용: " + boardDto.getBoardContents() + "\n");
        System.out.printf("조회수 : " + boardDto.getBoardView() + "\n" + "=====  댓글 =====" + "\n" );

        int i = 1;
        for(ReplyDto r : replyDtoList){
            System.out.printf("댓글 " + i++ + " : " + r.getReplyComment() + "\n" );
        }
    }


    @Test
    public void ReadBoardByUser() {

        List<BoardDto> UboardDtoList = boardService.ReadBoardByUser(Long.valueOf(1));

        int i = 0;
        for (BoardDto b : UboardDtoList) {
            System.out.printf("User : " + b.getUser().getUserName() + " / Title :" +
                    b.getBoardTitle() + " / content : " + b.getBoardContents() +
                    " / boardCount : " + i + "\n");
        }
    }
}
