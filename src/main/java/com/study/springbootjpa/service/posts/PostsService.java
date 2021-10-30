package com.study.springbootjpa.service.posts;

import com.study.springbootjpa.domain.posts.Posts;
import com.study.springbootjpa.domain.posts.PostsRepository;
import com.study.springbootjpa.web.dto.PostsResponseDto;
import com.study.springbootjpa.web.dto.PostsSaveRequestDto;
import com.study.springbootjpa.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id => " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id => " + id));

        return new PostsResponseDto(entity);
    }

/*
    update 기능을 보면, 데이터 베이스에 쿼리를 날리는 부분이 없음 => JPA의 영속성 컨텍스트 때문

    *영속성 컨텍스트
    entity를 영구 저장하는 환경. 일종의 논리적 개념이라고 볼 수 있으며, JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈림
    JPA의 EntityManager가 활성화된 상태로(Spring Data JPA 기본 옵션) 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지되는 상태
    이 상태에서 해당 데이터 값을 변경하면, 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영.
    즉, Entity 객체의 값만 병경하면 별도로 Update 쿼리를 날릴 필요가 없는 것 = dirty check

    orElseThrow() -> 예외처리
*/


}
