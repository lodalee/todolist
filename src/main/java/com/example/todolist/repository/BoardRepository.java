package com.example.todolist.repository;

import com.example.todolist.domain.Board.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
