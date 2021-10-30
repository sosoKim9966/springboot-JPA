package com.study.springbootjpa.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter               //lombok(필수x) 쉽게 삭제 할 수 있도록 위에 배치
@NoArgsConstructor    //lombok(필수x) - 기본 생성자를 자동으로 생성
@Entity               //JPA 어노테이션 - 테이블과 링크될 클래스임을 나타냄 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts {  //실제 DB 테이블과 매칭 될 클래스이며 보통 Entity 클래스라고도 함. JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, Entity 클래스의 수정을 통해 작업

    @Id //해당 테이블의 PK 필드(Long 타입의 auto_increment 추천)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 스프링 부트 2.0에서는 GenerationType.IDENTITY 추가시에 auto_increment 가능)
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼을 나타냄. 따로 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 됨. 문자열의 경우 varchar(255) 기본
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언할 경우 생성자에 포함된 빌드만 빌더에 포함됨
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

/*
    Entity 클래스에서 Setter 없이 값을 DB에 삽입하는 방법
    -> 생성자를 통해 최종값을 채운 후 DB에 삽입
    단, 값 변경이 필요한 경우에는 해당 이벤트에 맞는 public 메소드를 호출하여 변경해야함
 */

/*
    위의 경우 생성자 대신 @Builder를 통해 제공되는 빌더 클래스 사용
    생성자나 빌더나 생성 시점에 값을 채워주는 역할은 같음
    단, 새성자는 지금 채워야할 필드가 무엇인지 명확하게 지정할 수 없음

    생성자의 경우, Example(b, a)로 잘못 넣어도 코드 실행 전에 오류를 찾을 수 없음
    public Example(String a, String b){
        this.a = a;
        this.b = b;
    }

    builder의 경우 어느 필드에 어떤 값을 채워야 할지 명확하게 인지 가능
    Example.builder()
           .a(a)
           .b(b)
           .build();

 */

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}
