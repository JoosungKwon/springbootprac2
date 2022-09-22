package com.newlecture.kwonjoosung.springbootprac2.service.posts;

import com.newlecture.kwonjoosung.springbootprac2.domain.posts.Posts;
import com.newlecture.kwonjoosung.springbootprac2.domain.posts.PostsRepository;
import com.newlecture.kwonjoosung.springbootprac2.dto.PostsResponseDto;
import com.newlecture.kwonjoosung.springbootprac2.dto.PostsSavePequestDto;
import com.newlecture.kwonjoosung.springbootprac2.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSavePequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getID();
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        return new PostsResponseDto(entity);

    }

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
