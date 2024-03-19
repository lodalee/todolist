package com.example.todolist.domain.Board;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Getter
public class BoardRequestDto {

    @NotBlank(message = "반드시 입력해야 합니다.")
    @Size(min = 10, max = 100, message = "10자 이상 100자 미만으로 입력해주세요.")
    private String content;


}
