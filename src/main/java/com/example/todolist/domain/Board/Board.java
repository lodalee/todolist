package com.example.todolist.domain.Board;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
public class Board {
    @GeneratedValue
    @Id
    @Column(name = "board_id")
    private Long id;

    @Column
    private String content;

    @Enumerated(EnumType.STRING)
    private State state;

    public Board(BoardRequestDto requestDto){
        this.content = requestDto.getContent();
        this.state = State.GO;
    }

    // 비즈니스 로직 //
    public void setContent(String content){
        this.content = content;
    }

    //완료
    public void completeState(){
        this.state = State.COMPLETE;
    }
}
