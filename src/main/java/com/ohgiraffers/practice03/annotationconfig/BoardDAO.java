package com.ohgiraffers.practice03.annotationconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BoardDAO {

    private final Map<Long, BoardDTO> boardMap;

    public BoardDAO() {
        boardMap = new HashMap<>();

        boardMap.put(1L, new BoardDTO(1L,"저메추 해주세요", "제곧내", "ㅂㅇㅂ"));
        boardMap.put(2L, new BoardDTO(2L,"오노추 해주세요", "이따 운동가서 들을 거예요", "ㅅㅇㅅ"));
    }

    public BoardDTO selectBoard(Long id) {
        return boardMap.get(id);
    }

    public boolean insertBoard(BoardDTO board) {
        int before = boardMap.size();
        boardMap.put(board.getId(), board);
        int after = boardMap.size();
        return after > before ? true : false;
    }
}
