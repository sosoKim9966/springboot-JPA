package com.study.springbootjpa.web;

import com.study.springbootjpa.service.posts.PostsService;
import com.study.springbootjpa.web.dto.PostsResponseDto;
import com.study.springbootjpa.web.dto.PostsSaveRequestDto;
import com.study.springbootjpa.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor   //final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성 -> 해당 클래스의 의종성 관계가 변경될 때마다 생성자 코드를 계속 수정하지 않기 위해서 롬복 어노테이션 사용
@RestController
public class PostsApiController {

    //@AutoWired 권장하지 않음 -> 생성자로 Bean 주입 권장
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

}
