package com.j2kb.minipetpee.api.board.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class BoardPostSummaryResponse {
    private final Long id;
    private final String title;
    private final BoardPostImageResponse image;
    private final Integer viewCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdAt;
}
