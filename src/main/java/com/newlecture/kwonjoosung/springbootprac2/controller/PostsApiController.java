package com.newlecture.kwonjoosung.springbootprac2.controller;

import com.newlecture.kwonjoosung.springbootprac2.dto.PostsResponseDto;
import com.newlecture.kwonjoosung.springbootprac2.dto.PostsSavePequestDto;
import com.newlecture.kwonjoosung.springbootprac2.dto.PostsUpdateRequestDto;
import com.newlecture.kwonjoosung.springbootprac2.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);

    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSavePequestDto requestDto) {
        return postsService.save(requestDto);

    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);

    }
}
