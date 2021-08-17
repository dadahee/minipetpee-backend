package com.j2kb.minipetpee.api.album.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class AlbumPostResponse {
    private final Long id;
    private final String title;
    private final List<AlbumPostImageResponse> images;
    private final int viewCount;
    private final boolean visible;
}