package com.example.todolist.repository;

import com.example.todolist.domain.Board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Long> {
}
