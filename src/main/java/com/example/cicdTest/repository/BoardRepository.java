package com.example.cicdTest.repository;

import com.example.cicdTest.domain.Board;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends Repository<Board, Long> {

    void save(Board board);
}
