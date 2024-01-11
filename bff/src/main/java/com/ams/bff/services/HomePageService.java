package com.ams.bff.services;

import com.ams.bff.dtos.HomePostDto;
import com.ams.bff.dtos.PostDto;
import com.ams.bff.dtos.ProfileDto;
import com.ams.bff.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {

  private final RestTemplate restTemplate;

  public HomePageService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public PostDto[] getPosts() {
    return restTemplate.getForObject("http://post-service:8082/api/posts", PostDto[].class);
  }

  public UserDto getUser(Long id) {
    return restTemplate.getForObject("http://user-service:8080/api/users/" + id, UserDto.class);
  }

  public ProfileDto getProfile(Long id) {
    return restTemplate.getForObject("http://profile-service:8081/api/profiles/" + id, ProfileDto.class);
  }

  public List<HomePostDto> getHomePosts(int n) {
    List<PostDto> posts = List.of(getPosts());

    List<HomePostDto> homePosts = new ArrayList<>();

    posts.stream().forEach(post -> {

      ProfileDto profile = getProfile(post.getProfileId());
      UserDto user = getUser(profile.getUserId());

      HomePostDto build = HomePostDto.builder()
              .id(profile.getId())
              .authorName(user.getFirstName() + " " + user.getLastName())
              .postTitle(post.getTitle())
              .limitedContent(post.getContent().substring(0, n))
              .userId(user.getId())
              .build();

      homePosts.add(build);
    });

    return homePosts;
  }
}
