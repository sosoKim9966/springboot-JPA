package com.study.springbootjpa.web.dto;

import com.study.springbootjpa.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

/*
    Entity 클래스와 유사하지만 DTO 클래스 추가 생성
    Entity 클래스를 Request/Response 클래스로 사용하면 안됨
    데이터베이스와 맞닿은 핵심 클래스로 Entity 클래스를 기준으로 테이블이 생성되고 스키마가 변경됨
    Request/Response 용도의 DTO는 View를 위한 클래스라 자주 변경이 필요하기 때문에,
    View Layer/DB Layer 역할 분리를 위해 위와 같이 DTO 클래스를 따로 사용하는 것이 좋음
    Entity 클래스와 Controller에서 사용할 DTO는 꼭 분리해서 사용해야 함.
*/


}
