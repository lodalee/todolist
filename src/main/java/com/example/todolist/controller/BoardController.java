package com.example.todolist.controller;

import com.example.todolist.domain.Board.BoardRequestDto;
import com.example.todolist.message.SuccessMessage;
import com.example.todolist.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

//    @GetMapping("")   // 새로운 일 추가하기
//    public String NewFoam(){
//        return "Board/new";
//    }
//
//    @PostMapping("/create")
//    public String createBoard(BoardForm boardForm) {
////        log.info(boardForm.toString());
////        System.out.println(boardForm.toString());
//        //1. dto 엔티티로 변환
//        Board board = boardForm.toEntity();
//        Board saved = boardRepository.save(board);
////        log.info(saved.toString());
////        System.out.println(saved.toString());
//        return "";
//    }
//
//    @GetMapping("/{id}") //리스트 번호를 변수를 사용함
//    public String show(@PathVariable Long id, Model model){
//        Board boardEntity= boardRepository.findById(id)  //레파지터리에서 id를 찾아서 해당객체를 optional타입으로 반환
//                .orElse(null);
//        model.addAttribute("Board", "boardEntity");
//        return "Boards/show";
//    }

    /**
     * 게시글 작성
     */
    @PostMapping("")
    public String createBoard(@RequestBody @Valid BoardRequestDto requestDto) {
        boardService.create(requestDto);
        return SuccessMessage.BOARD_CREATE_COMPLETE;
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/{boardId}")
    public String updateBoard(
            @PathVariable Long boardId,
            @RequestBody @Valid BoardRequestDto requestDto) {
        boardService.update(requestDto, boardId);
        return SuccessMessage.BOARD_UPDATE_COMPLETE;
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{boardId}")
    public String deleteBoard(@PathVariable Long boardId){
        boardService.delete(boardId);
        return SuccessMessage.BOARD_DELETE_COMPLETE;
    }

    /**
     * 완료
     */
    @PutMapping("/{boardId}/complete")
    public String complete(@PathVariable Long boardId){
        boardService.complete(boardId);
        return SuccessMessage.BOARD_COMPLETE;
    }
}
