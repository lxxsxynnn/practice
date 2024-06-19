package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import jdk.jfr.Name;
import org.springframework.context.annotation.Bean;

public class ContextConfiguration {

    @Bean
    @Name("board")
    public BoardDTO getBoard(){
        return new BoardDTO(1L, "title01", "content01", "bwriter01");
    }
}
