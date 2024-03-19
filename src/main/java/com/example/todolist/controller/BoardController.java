package com.example.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PostController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/Board")   // 새로운 일 추가하기
    public String NewFoam(){
        return "Board/new";
    }

    @PostMapping("/Board/create")
    public String createBoard(BoardForm boardForm) {
//        log.info(boardForm.toString());
        System.out.println(boardForm.toString());
        //1. dto 엔티티로 변환
        Board board = boardForm.toEntity();
        Board saved = boardRepository.save(board);
//        log.info(saved.toString());
        System.out.println(saved.toString());
        return "";
    }
}
