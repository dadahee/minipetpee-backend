package com.j2kb.minipetpee.api.album.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveAlbumPostCommentRequest {
    private Long memberId;
    private String content;
}