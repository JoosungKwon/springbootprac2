package com.newlecture.kwonjoosung.springbootprac2.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository ;

    @AfterEach
    public void clean_up() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장하기() {

        //given
        String title = "title";
        String content = "content";
        String author = "author";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        //when
        List<Posts> postsList =  postsRepository.findAll();
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }

//    @Test
//    public void clean_up() {
//        postsRepository.deleteAll();
//    }
//
//    @Test
//    public void clean_up() {
//        postsRepository.deleteAll();
//    }


}
