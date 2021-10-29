package com.study.springbootjpa.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository 어노테이션을 추가할 필요는 없지만 Entity 클래스와 기본 Entity Repository는 함께 위치해야 함.
public interface PostsRepository extends JpaRepository<Posts, Long> {  //JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD 메소드 자동 생성

}
