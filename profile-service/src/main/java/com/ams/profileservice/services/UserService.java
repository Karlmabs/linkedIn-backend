package com.ams.profileservice.services;

import com.ams.profileservice.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

  private final RestTemplate restTemplate;

  public UserService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public UserDto getUser(Long id) {
    return restTemplate.getForObject("http://user-service:8080/api/users/" + id, UserDto.class);
  }
}
