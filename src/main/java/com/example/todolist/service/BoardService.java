package com.example.todolist.service;

import com.example.todolist.domain.Board.Board;
import com.example.todolist.domain.Board.BoardRequestDto;
import com.example.todolist.repository.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardJpaRepository boardRepository;
    public void create(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
    }

    public void update(BoardRequestDto requestDto, Long boardId) {
        Board board = findBoardId(boardId);
        board.setContent(requestDto.getContent());
    }


    public void delete(Long boardId) {
        Board board = findBoardId(boardId);
        boardRepository.delete(board);
    }

    public void complete(Long boardId) {
        Board board = findBoardId(boardId);
        board.completeState();
    }

    public Board findBoardId(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("해당 글은 존재하지 않습니다."));
    }
}
