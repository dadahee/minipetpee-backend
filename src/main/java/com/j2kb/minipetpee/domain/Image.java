package com.j2kb.minipetpee.domain;

import com.j2kb.minipetpee.domain.posts.AlbumPost;
import com.j2kb.minipetpee.domain.posts.Post;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private AlbumPost album;
}
