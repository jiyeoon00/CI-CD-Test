package com.example.cicdTest.controller;

import com.example.cicdTest.controller.dto.request.BoardRequestDto;
import com.example.cicdTest.external.client.aws.S3Service;
import com.example.cicdTest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final S3Service s3Service;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@ModelAttribute @Valid final BoardRequestDto requestDto) {
        String boardThumbnailImageUrl = s3Service.uploadImage(requestDto.getThumbnail(), "board");
        boardService.create(boardThumbnailImageUrl, requestDto.getTitle());
        return "게시물 생성 완료";
    }
}
