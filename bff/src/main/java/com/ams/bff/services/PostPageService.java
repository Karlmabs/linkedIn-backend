package com.ams.bff.services;

import com.ams.bff.dtos.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostPageService {

  private final RestTemplate restTemplate;

  public PostPageService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public PostPageDto getAPost(int id) {
    PostDto postDto = restTemplate.getForObject("http://post-service:8082/api/posts/" + id, PostDto.class);
    ProfileDto profile = restTemplate.getForObject("http://profile-service:8081/api/profiles/" + postDto.getProfileId(), ProfileDto.class);
    UserDto user = restTemplate.getForObject("http://user-service:8080/api/users/" + profile.getUserId(), UserDto.class);

    Set<CommentPageDto> comments = new HashSet<>();

    postDto.getComments().stream().forEach(commentDto -> {
      if(commentDto.getParentCommentId() == null){
        CommentPageDto build = CommentPageDto.builder()
                .authorName(user.getFirstName() + " " + user.getLastName())
                .content(commentDto.getContent())
                .creationDate(commentDto.getCreationDate())
                .build();
        comments.add(build);
      }
    });

    PostPageDto build = PostPageDto.builder()
            .id(postDto.getId())
            .profileId(profile.getId())
            .authorName(user.getFirstName() + " " + user.getLastName())
            .postTitle(postDto.getTitle())
            .content(postDto.getContent())
            .creationDate(postDto.getCreationDate())
            .comments(comments)
            .build();

    return build;
  }
}
