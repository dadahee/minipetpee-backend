package com.j2kb.minipetpee.api.main.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb.minipetpee.api.board.domain.BoardPost;
import com.j2kb.minipetpee.global.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private final Long id;
    private final String title;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime createdAt;

    private String imageUrl;
    private String content;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.imageUrl = post.imageUrl();
        // 개인적으로 인기 게시글 목록에 본문 노출이 필요할까.. 하는 생각이... 듭니다...
        if (post instanceof BoardPost) {
            this.content = ((BoardPost) post).getContent();
        }
    }
}