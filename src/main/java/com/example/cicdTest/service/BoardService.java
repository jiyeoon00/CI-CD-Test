package com.example.cicdTest.service;

import com.example.cicdTest.domain.Board;
import com.example.cicdTest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void create(String boardThumbnailImageUrl, String title) {
        Board newBoard = Board.newInstance(boardThumbnailImageUrl, title);

        boardRepository.save(newBoard);
    }
}
