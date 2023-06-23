package com.example.cicdTest.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String thumbnail;

    @Column(nullable = false)
    private String title;

    private Board(String thumbnail, String title) {
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public static Board newInstance(String thumbnail, String title) {
        return new Board(thumbnail, title);
    }
}
