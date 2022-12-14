package com.newlecture.kwonjoosung.springbootprac2.dto;

import com.newlecture.kwonjoosung.springbootprac2.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity ) {
        this.id = entity.getID();
        this.title = entity.getTitle();
        this.content = entity.getTitle();
        this.author = entity.getAuthor();

    }
}
