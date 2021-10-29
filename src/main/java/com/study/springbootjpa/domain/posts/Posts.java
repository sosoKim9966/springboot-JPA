package com.study.springbootjpa.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter               //lombok(필수x) 쉽게 삭제 할 수 있도록 위에 배치
@NoArgsConstructor    //lombok(필수x)
@Entity               //JPA 어노테이션
public class Posts {  //실제 DB 테이블과 매칭 될 클래스이며 보통 Entity 클래스라고도 함. JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, Entity 클래스의 수정을 통해 작업

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
